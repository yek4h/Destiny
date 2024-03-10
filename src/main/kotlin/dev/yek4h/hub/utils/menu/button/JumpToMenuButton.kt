package dev.yek4h.hub.utils.menu.button

import dev.yek4h.hub.utils.menu.Button
import dev.yek4h.hub.utils.menu.Menu
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

class JumpToMenuButton(private val menu: Menu, private val itemStack: ItemStack) : Button() {
    override fun getButtonItem(player: Player?): ItemStack {
        return itemStack
    }

    override fun clicked(player: Player?, clickType: ClickType?) {
        menu.openMenu(player!!)
    }
}