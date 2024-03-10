package dev.yek4h.hub.ui

import dev.t4yrn.yek4h.util.ItemBuilder
import dev.yek4h.hub.ui.buttons.HubButtons
import dev.yek4h.hub.utils.menu.Button
import dev.yek4h.hub.utils.menu.Menu
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

class HubSelectorUI : Menu() {

    override fun getTitle(player: Player?): String {
        return "&b&lHub Selector"
    }

    override fun getButtons(player: Player?): MutableMap<Int, Button?> {
        val buttons = HashMap<Int, Button?>()

        for (i in 12..14) {
            buttons[i] = HubButtons(i)
        }

        buttons[9] = object : Button() {
            override fun getButtonItem(player: Player?): ItemStack {
                return ItemBuilder(Material.NETHER_STAR)
                    .name("&bClick here to go back to Selector Menu")
                    .build()
            }

            override fun clicked(player: Player?, clickType: ClickType?) {
                player!!.closeInventory()
                SelectorUI().openMenu(player)
            }
        }

        buttons[4] = object : Button() {
            override fun getButtonItem(player: Player?): ItemStack {
                return ItemBuilder(Material.INK_SACK)
                    .data(9)
                    .name(if (player!!.isSpanish) "&dSeleccionador de Lobby" else "&dLobby Selector")
                    .lore(
                        if (player.isSpanish) mutableListOf(
                            "",  //SPANISH JOINED THE CHAT!
                            "&bActualmente estas en el",
                            "&bmenu para cambiar de lobby!",
                            ""
                        ) else mutableListOf(
                            "",  //ENGLISH JOINED THE CHAT!
                            "&bActually you're on the",
                            "&blobby selector menu",
                            ""
                        )
                    )

                    .build()
            }

        }
        return buttons
    }

    override fun size(buttons: Map<Int, Button?>): Int {
        return 3 * 9
    }
}