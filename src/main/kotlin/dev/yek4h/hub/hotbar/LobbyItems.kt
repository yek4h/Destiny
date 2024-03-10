package dev.yek4h.hub.hotbar

import dev.t4yrn.yek4h.util.ItemBuilder
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object LobbyItems {
    var hidden: Boolean = false


    fun setItems(player: Player) {
        player.inventory.setItem(4, getSelector())
        player.inventory.setItem(8, getPlayerHide())
        player.inventory.setItem(0, getEnderButt())
    }

    private fun getSelector(): ItemStack {
        return ItemBuilder(Material.COMPASS)
            .name("&dServer Selector").build()
    }

    private fun getEnderButt(): ItemStack {
        return ItemBuilder(Material.ENDER_PEARL)
            .name("&eEnder :D").build()
    }

    private fun getPlayerHide(): ItemStack {
        val isDisabled = if (hidden) "&cShow Players" else "&bHide Players"
        val data = if (hidden) 8 else 10
        return ItemBuilder(Material.INK_SACK)
            .name(isDisabled)
            .data(data).build()
    }
}