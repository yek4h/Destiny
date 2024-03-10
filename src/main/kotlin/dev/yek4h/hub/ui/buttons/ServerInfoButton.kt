package dev.yek4h.hub.ui.buttons

import dev.t4yrn.yek4h.util.ItemBuilder
import dev.t4yrn.yek4h.util.TextureUtil
import dev.yek4h.hub.utils.menu.Button
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class ServerInfoButton : Button() {
    override fun getButtonItem(player: Player?): ItemStack {
        return ItemBuilder(Material.SKULL_ITEM)
            .durability(3)
            .setSkullTexture(TextureUtil.HAPPY_EARTH_TEXTURE)
            .name("&dServer Information")
            .lore(listOf(
                "",
                "&bIP's: ",
                "&f NA: swimp.life / na.swimp.life",
                "&f We're working on more proxies!",
                "",
                "&bSocial Feeds:",
                "&f https://discord.gg/TGGZynkGtQ",
                "&f store.swimp.life",
                "",
                "&bTeamSpeak: ",
                "&f ts.swimp.life", ""))
            .build()

    }
}