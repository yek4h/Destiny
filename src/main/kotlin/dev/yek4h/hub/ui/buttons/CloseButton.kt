package dev.yek4h.hub.ui.buttons

import dev.t4yrn.yek4h.util.ItemBuilder
import dev.yek4h.hub.utils.menu.Button
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class CloseButton : Button() {
    override fun getButtonItem(player: Player?): ItemStack {
        return ItemBuilder(Material.BED)
            .name("Click to close the menu").build()
    }
}