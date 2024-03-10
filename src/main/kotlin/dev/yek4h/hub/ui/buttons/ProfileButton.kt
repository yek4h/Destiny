package dev.yek4h.hub.ui.buttons

import dev.t4yrn.yek4h.util.ItemBuilder
import dev.yek4h.hub.utils.menu.Button
import land.combo.darling.spigot.Darling
import land.combo.darling.spigot.profile.Profile
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class ProfileButton : Button() {
    override fun getButtonItem(player: Player?): ItemStack {
        val data: Profile = Darling.getInstance().profiles.get(player!!.uniqueId)
        val rank = data.highestRank.color.toString() + data.highestRank.name
        return ItemBuilder(Material.SKULL_ITEM)
            .durability(3)
            .setSkullOwner(player.uniqueId)
            .name(player.displayName +  data.serverColor.translated + "'s Profile" )
        .lore(
            listOf("",
        "&fYour rank: " + data.serverColor.translated + rank,
        "&fExpires: " + data.getGrant(data.highestRank.name).issuedDuration,
        "",
        "&fTotal Punishments: " + data.serverColor.translated + data.punishments.size,
        "",
        "&aYou're connected through " + "swimp.life"))
        .build()
    }
}