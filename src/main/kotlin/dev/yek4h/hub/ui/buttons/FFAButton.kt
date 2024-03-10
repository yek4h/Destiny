package dev.yek4h.hub.ui.buttons

import dev.t4yrn.yek4h.util.ItemBuilder
import dev.yek4h.hub.ui.subselector.FFASelectorUI
import dev.yek4h.hub.utils.menu.Button
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

class FFAButton : Button() {
    override fun getButtonItem(player: Player?): ItemStack {
        return ItemBuilder(Material.ENDER_PEARL)
            .name("&b&lFFA Games &7[1.7x - 1.8x]")
            .lore(listOf(
                "&8&o(ComboFFA, BuildFFA, SoupFFA)",
                "",
                "&b▶ &fCustom Kits",
                "&b▶ &fBounties & Killstreak",
                "&b▶ &fLeaderboard & Tops",
                "",
                "&bClick to play!")).build()
    }

    override fun clicked(player: Player?, clickType: ClickType?) {
        player!!.closeInventory()
        player.updateInventory()

        FFASelectorUI().openMenu(player)
    }
}