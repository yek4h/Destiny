package dev.yek4h.hub.ui.buttons

import dev.t4yrn.yek4h.util.ItemBuilder
import dev.yek4h.hub.utils.menu.Button
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

class KitmapButton : Button() {
    override fun getButtonItem(player: Player?): ItemStack {
        return ItemBuilder(Material.DIAMOND_PICKAXE)
            .name("&b&lKitmap")
            .clearLore()
            .lore(listOf("&8&o(Competitive)",
                "",
                "&7Map information:",
                "&b▶ &f15 Members, 1 Ally",
                "&b▶ &fSharpness 2, Protection 2",
                "",
                "&b&lSOTW&f: We're working on this!",
                "&b&lEOTW&f: Same as up",
                "",
                "&bClick here to play!"))
            .build()
    }

    override fun clicked(player: Player?, clickType: ClickType?) {
        player!!.closeInventory()
        player.updateInventory()
        player.performCommand("joinqueue Kitmap-NA")
    }
}