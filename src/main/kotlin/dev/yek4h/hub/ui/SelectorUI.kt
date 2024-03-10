package dev.yek4h.hub.ui

import dev.yek4h.hub.ui.buttons.*
import dev.yek4h.hub.utils.menu.*

import dev.t4yrn.yek4h.util.ItemBuilder

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

class SelectorUI : Menu() {
    override fun getTitle(player: Player?): String {
    return "&bServer Selector"
    }

    override fun getButtons(player: Player?): MutableMap<Int, Button?> {
        val buttons = HashMap<Int, Button?>()

        buttons[4] = object : Button() {
            override fun getButtonItem(player: Player?): ItemStack {
                return ItemBuilder(Material.INK_SACK)
                    .name("&bServer Selector")
                .lore(listOf(
                "",
                "&bYou're actually seeing the server",
                "&bselector menu for connect",
                "&bto your favorite server",
                ""))
                    .build()
            }
        }

        buttons[18] = object : Button() {
            override fun getButtonItem(player: Player?): ItemStack {
                return ItemBuilder(Material.NETHER_STAR)
                    .name("&a;)")
                    .build()
            }
        }

        buttons[26] = object : Button() {
            override fun getButtonItem(player: Player?): ItemStack {
                return  ItemBuilder(Material.NETHER_STAR)
                    .name("&bLobby Selector")
                    .lore(listOf(
                        "",
                        "&aClick here to select",
                        "&aanother lobby :D",
                        ""))
                    .build()
            }

            override fun clicked(player: Player?, clickType: ClickType?) {
                player!!.closeInventory()
                player.updateInventory()
                HubSelectorUI().openMenu(player)
            }
        }

        buttons[20] = UHCButton()
        buttons[21] = PracticeButton()
        buttons[22] = KitmapButton()
        buttons[23] = FFAButton()
        buttons[24] = HCFButton()
        buttons[39] = ServerInfoButton()
        buttons[41] = ProfileButton()
        return buttons
    }

    override fun size(buttons: Map<Int, Button?>): Int {
        return 5 * 9
    }

}