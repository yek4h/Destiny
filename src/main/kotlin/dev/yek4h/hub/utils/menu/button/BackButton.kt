package dev.yek4h.hub.utils.menu.button

import dev.yek4h.hub.utils.menu.Button
import dev.yek4h.hub.utils.menu.Menu
import dev.t4yrn.yek4h.util.CC
import dev.t4yrn.yek4h.util.ItemBuilder
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import java.util.*

class BackButton(private val back: Menu) : Button() {
    override fun getButtonItem(player: Player?): ItemStack {
        return ItemBuilder(Material.REDSTONE)
            .name(CC.RED.toString() + CC.BOLD + "Back")
            .lore(
                listOf<String?>(
                    CC.RED.toString() + "Click here to return to",
                    CC.RED.toString() + "the previous menu."
                )
            )
            .build()
    }

    override fun clicked(player: Player?, clickType: ClickType?) {
        playNeutral(player!!)
        back.openMenu(player)
    }
}