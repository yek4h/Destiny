package dev.yek4h.hub.ui.subselector

import dev.t4yrn.yek4h.util.ItemBuilder
import dev.yek4h.hub.utils.menu.Button
import dev.yek4h.hub.utils.menu.Menu
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class FFASelectorUI : Menu() {
    override fun getTitle(player: Player?): String {

        return ""
    }

    override fun getButtons(player: Player?): MutableMap<Int, Button?> {
        val buttons = HashMap<Int, Button?>()
        buttons[11] = object : Button() {
            override fun getButtonItem(player: Player?): ItemStack {
                return ItemBuilder(Material.MUSHROOM_SOUP)
                    .name("&dSoupFFA")
                    .build()
            }
        }

        buttons[13] = object : Button() {
            override fun getButtonItem(player: Player?): ItemStack {
                return ItemBuilder(Material.ENDER_PEARL)
                    .name("&bComboFFA")
                    .build()
            }
        }

        buttons[15]  = object : Button() {
            override fun getButtonItem(player: Player?): ItemStack {
                return ItemBuilder(Material.LAVA_BUCKET)
                    .name("&eUHC-FFA")
                    .build()
            }
        }
        return buttons
    }

    override fun size(buttons: Map<Int, Button?>): Int {
        return 3 * 9
    }
}