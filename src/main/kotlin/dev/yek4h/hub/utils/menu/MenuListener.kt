package dev.yek4h.hub.utils.menu

import dev.t4yrn.yek4h.event.EventManager
import dev.yek4h.hub.Destiny
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventPriority
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent

class MenuListener {
    init {
        EventManager.subscribe(InventoryClickEvent::class, EventPriority.HIGH) {
            val player = whoClicked as Player
            val openMenu = Menu.currentlyOpenedMenus[player.name]
            if (openMenu != null) {
                if (slot != rawSlot) {
                    if (click == ClickType.SHIFT_LEFT || click == ClickType.SHIFT_RIGHT) {
                        isCancelled = true
                    }
                    return@subscribe
                }
                if (openMenu.buttons.containsKey(slot)) {
                    val button = openMenu.buttons[slot]
                    val cancel = button!!.shouldCancel(player, click)
                    if (!cancel && (click == ClickType.SHIFT_LEFT || click == ClickType.SHIFT_RIGHT)) {
                        isCancelled = true
                        if (currentItem != null) {
                            player.inventory.addItem(currentItem)
                        }
                    } else {
                        isCancelled = cancel
                    }
                    button.clicked(player, click)
                    button.clicked(player, slot, click, hotbarButton)
                    if (Menu.currentlyOpenedMenus.containsKey(player.name)) {
                        val newMenu = Menu.currentlyOpenedMenus[player.name]
                        if (newMenu === openMenu) {
                            val buttonUpdate = button.shouldUpdate(player, click)
                            if (buttonUpdate) {
                                openMenu.isClosedByMenu = true
                                newMenu.openMenu(player)
                            }
                        }
                    } else if (button.shouldUpdate(player, click)) {
                        openMenu.isClosedByMenu = true
                        openMenu.openMenu(player)
                    }
                    if (isCancelled) {
                        Bukkit.getScheduler().runTaskLater(Destiny.instance, { player.updateInventory() }, 1L)
                    }
                } else {
                    if (currentItem != null) {
                        isCancelled = true
                    }
                    if (click == ClickType.SHIFT_LEFT || click == ClickType.SHIFT_RIGHT) {
                        isCancelled = true
                    }
                }
            }
        }

        EventManager.subscribe(InventoryCloseEvent::class, EventPriority.HIGH) {
            val player = player as Player
            val openMenu = Menu.currentlyOpenedMenus[player.name]
            if (openMenu != null) {
                openMenu.onClose(player)
                Menu.currentlyOpenedMenus.remove(player.name)
            }
        }
    }
}