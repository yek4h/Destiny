package dev.yek4h.hub.listeners

import dev.t4yrn.yek4h.event.EventManager
import dev.t4yrn.yek4h.util.CC
import dev.yek4h.hub.hotbar.LobbyItems
import dev.yek4h.hub.ui.SelectorUI
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.util.Vector
import java.lang.Math.sin
import java.lang.Math.toRadians
import kotlin.math.cos

class HotbarListener {
    init {
        EventManager.subscribe(PlayerInteractEvent::class) {
            if (action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK || action == Action.RIGHT_CLICK_BLOCK) {
                if (player.gameMode == GameMode.CREATIVE) return@subscribe
                if (player.itemInHand.type === Material.AIR) return@subscribe
                if (item.type.equals(Material.COMPASS)) {
                    SelectorUI().openMenu(player)
                    player.world.playSound(player.location, Sound.ORB_PICKUP, 1f, 1f)
                    return@subscribe
                }

                if (item.type.equals(Material.ENDER_PEARL)) {
                    isCancelled = true
                    player.updateInventory()

                    val direction: Vector = sex(player)
                    direction.multiply(3.5)
                    player.velocity = direction
                    return@subscribe
                }
                if (item.type.equals(Material.INK_SACK)) {
                    if (!LobbyItems.hidden) {
                        Bukkit.getServer().onlinePlayers.forEach(player::hidePlayer)
                        player.sendMessage(CC.translate("&cPlayers are now hidden"))
                        LobbyItems.hidden = true
                        LobbyItems.setItems(player)
                        return@subscribe
                    }
                    LobbyItems.hidden = false
                    Bukkit.getServer().onlinePlayers.forEach(player::showPlayer)
                    player.sendMessage(CC.translate("&aPlayers are now shown"))
                    LobbyItems.setItems(player)
                    return@subscribe
                }
            }
            isCancelled = true
        }
    }

    private fun sex(player: Player): Vector {
        val pitch: Float = player.location.pitch - 10
        val yaw: Float = player.location.yaw + 90

        val x = cos(toRadians(yaw.toDouble())) * cos(toRadians(pitch.toDouble()))
        val y = kotlin.math.sin(toRadians(pitch.toDouble()))
        val z = kotlin.math.sin(toRadians(yaw.toDouble())) * cos(toRadians(pitch.toDouble()))

        return Vector(x, -y, z)
    }
}