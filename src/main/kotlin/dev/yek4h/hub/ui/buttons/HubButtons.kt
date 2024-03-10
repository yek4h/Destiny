package dev.yek4h.hub.ui.buttons

import dev.t4yrn.yek4h.util.ItemBuilder
import dev.yek4h.hub.utils.menu.Button
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import kotlin.system.exitProcess

class HubButtons(
    private val hubNumber: Int = 0
) : Button() {

    override fun getButtonItem(player: Player?): ItemStack {
        val total: String = "" + (11 - hubNumber)
        if (Bukkit.getServerName().equals("Hub$total")) {
            return ItemBuilder(Material.INK_SACK)
                .durability(12)
                .name("&b&lHub" + total.replace("-", "-0"))
                .lore(
                    if (player!!.isSpanish)
                        mutableListOf("") else mutableListOf
                        ("", "&7• &cYou're connected on this hub!", "")
                )
                .build()

        } else {
            return ItemBuilder(Material.INK_SACK)
                .durability(12)
                .name("&b&lHub" + total.replace("-", "-0"))
                .lore(
                    if (player!!.isSpanish) mutableListOf("") else mutableListOf(
                        "",
                        "&7• &aClick to connect to this Hub",
                        ""
                    )
                )
                .build()
        }
    }

    override fun clicked(player: Player?, clickType: ClickType?) {
        val total: String = "" + (11 - hubNumber)
        if (Bukkit.getServerName().equals("Hub$total")) {
            return
        }

        player!!.closeInventory()
        player.updateInventory()
        player.performCommand("joinqueue hub" + total.replace("-", "-0"))
    }
}