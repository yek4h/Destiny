package dev.yek4h.hub.ui.buttons

import dev.t4yrn.yek4h.util.ItemBuilder
import dev.txnio.samurai.util.CC
import dev.yek4h.hub.utils.menu.Button
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

class UHCButton : Button() {
    override fun getButtonItem(player: Player?): ItemStack {
        return ItemBuilder(Material.GOLDEN_APPLE)
            .name("&b&lUHC Lobby &7[1.7x - 1.8x]")
            .lore(listOf(
                "&8&o(UHC, Meetup, UHC Run)",
                "",
                "&b▶ &fDaily UHC Games",
                "&b▶ &fPractice FFA",
                "&b▶ &fCosmetics",
                "&b▶ &fLeaderboards & Holograms",
                "&7 &7 &8(Levels, Wins & Killstreaks)",
                "",
                "&bClick here to choose a region!"
            ))
            .build()
    }

    override fun clicked(player: Player?, clickType: ClickType?) {
        player!!.closeInventory()
        player.sendMessage(CC.translate("&aWe're working on this!"))
    }
}