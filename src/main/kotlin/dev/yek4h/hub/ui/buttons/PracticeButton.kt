package dev.yek4h.hub.ui.buttons

import dev.t4yrn.yek4h.util.ItemBuilder
import dev.yek4h.hub.utils.menu.Button
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

class PracticeButton : Button(){
    override fun getButtonItem(player: Player?): ItemStack {
        return ItemBuilder(Material.DIAMOND_SWORD)
            .name("&b&lPractice")
            .lore(listOf("",
                "&b▶ &fRanked & Unranked Ladders",
                "&b▶ &fLeaderboard & Holograms",
                "&b▶ &fParty's, Events and Tournaments!",
                "",
                "&bClick to select a region!"))
            .build()
    }

    override fun clicked(player: Player?, clickType: ClickType?) {
        player!!.closeInventory()
        player.updateInventory()
        player.performCommand("joinqueue Practice-NA")
    }
}