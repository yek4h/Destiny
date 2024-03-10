package dev.yek4h.hub.listeners

import dev.t4yrn.yek4h.event.EventManager
import dev.t4yrn.yek4h.scoreboard.Aether
import dev.t4yrn.yek4h.scoreboard.board.Board
import dev.t4yrn.yek4h.scoreboard.event.BoardCreateEvent
import dev.yek4h.hub.Destiny
import dev.yek4h.hub.hotbar.LobbyItems
import land.combo.darling.shared.tools.chat.CC
import land.combo.darling.spigot.Darling
import land.combo.darling.spigot.profile.Profile
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.FoodLevelChangeEvent
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.*
import org.bukkit.event.weather.WeatherChangeEvent

class PlayerListener {

    init {
        EventManager.subscribe(PlayerJoinEvent::class) {
            if (Board.getByPlayer(player) == null) {
                val board: Aether = Destiny.instance.aether
                Bukkit.getPluginManager().callEvent(BoardCreateEvent(Board(player, board, board.options), player))
            }
            player.inventory.clear()
            player.teleport(player.world.spawnLocation)
            player.foodLevel = 20
            LobbyItems.setItems(player)
        }

        EventManager.subscribe(PlayerMoveEvent::class) {
            if (player.location.y <= 0) player.teleport(player.world.spawnLocation)
        }

        EventManager.subscribe(PlayerDropItemEvent::class) {
            if (player.gameMode == GameMode.CREATIVE) {
                return@subscribe
            }
            isCancelled = true
        }

        EventManager.subscribe(PlayerPickupItemEvent::class) {
            if (player.gameMode == GameMode.CREATIVE) {
                return@subscribe
            }
            isCancelled = true
        }

        EventManager.subscribe(BlockBreakEvent::class) {
            if (player.gameMode == GameMode.CREATIVE) {
                return@subscribe
            }
            isCancelled = true
        }

        EventManager.subscribe(BlockPlaceEvent::class) {
            if (player.gameMode == GameMode.CREATIVE) {
                return@subscribe
            }

            isCancelled = true
        }

        EventManager.subscribe(InventoryClickEvent::class) {
            val player: Player = whoClicked as Player
            if (player.gameMode == GameMode.CREATIVE) {
                return@subscribe
            }

            isCancelled = true
        }

        EventManager.subscribe(FoodLevelChangeEvent::class) {
            val player: Player = entity as Player
            if (player.gameMode == GameMode.CREATIVE) {
                return@subscribe
            }
            player.foodLevel = 20
            isCancelled = true
        }

        EventManager.subscribe(WeatherChangeEvent::class) {
            if (toWeatherState()) isCancelled = true
        }

        EventManager.subscribe(AsyncPlayerChatEvent::class) {
            val profile: Profile = Darling.getInstance().profiles.get(player.uniqueId)
            if (profile.isBanned) {
                player.sendMessage(CC.translate(profile.banningPunishmentMessage))
                isCancelled = true
            }
        }

        EventManager.subscribe(PlayerInteractEvent::class) {
            val profile: Profile = Darling.getInstance().profiles.get(player.uniqueId)
            if (profile.isBanned) {
                player.sendMessage(CC.translate(profile.banningPunishmentMessage))
                isCancelled = true
                player.closeInventory()
                player.updateInventory()
            }
        }

        EventManager.subscribe(EntityDamageEvent::class) {
            isCancelled = true
        }



    }
}



    /*@EventHandler
    fun onPlayerDropItemEvent(event: PlayerDropItemEvent) {
        val player = event.player
        if (player.gameMode.equals(GameMode.CREATIVE)) {
            return
        }
        event.isCancelled = true
    }

    fun onPlayerMoveEvent(event: PlayerMoveEvent) {
        if (event.player.location.y <= 0) {
            event.player.teleport(event.player.world.spawnLocation)
        }
    }*/



//}