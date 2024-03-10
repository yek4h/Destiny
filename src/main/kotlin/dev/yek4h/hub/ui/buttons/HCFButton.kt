package dev.yek4h.hub.ui.buttons

import dev.t4yrn.yek4h.util.ItemBuilder
import dev.yek4h.hub.utils.menu.Button
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

class HCFButton : Button(){
    override fun getButtonItem(player: Player?): ItemStack {
        return ItemBuilder(Material.BOW)
            .name("&b&lHCFactions &7[1.7x - 1.8x]")
            .lore(listOf("&8&oHCFactions &7[1.7x - 1.8x]",
                "&8&o(Competitive)",
                "",
                "&7Map Information",
                "&b▶ 7 members, 1 ally",
                "&b▶ Sharpness 1, Protection 1",
                "",
                "&a&lEvent: &cNone",
                "",
                "&b&lSOTW&f: Soon",
                "&c&lEOTW&f: Soon",
                "",
                "&bClick to join to this queue!"))
            .build()
    }

    override fun clicked(player: Player?, clickType: ClickType?) {
        player!!.closeInventory()
        player.updateInventory()
        player.performCommand("joinqueue HCF")
    }
}