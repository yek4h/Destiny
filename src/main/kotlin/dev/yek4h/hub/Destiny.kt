package dev.yek4h.hub

import dev.t4yrn.yek4h.`class`.ClassManager
import dev.t4yrn.yek4h.event.EventManager
import dev.t4yrn.yek4h.scoreboard.Aether
import dev.t4yrn.yek4h.scoreboard.AetherOptions
import dev.yek4h.hub.listeners.HotbarListener
import dev.yek4h.hub.listeners.PlayerListener
import dev.yek4h.hub.scoreboard.ScoreboardAdapter
import dev.yek4h.hub.utils.menu.MenuListener
import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.World
import org.bukkit.entity.Entity
import org.bukkit.plugin.java.JavaPlugin
import java.util.function.Consumer

class Destiny : JavaPlugin() {
    companion object {
        @JvmStatic lateinit var instance: Destiny
    }

    lateinit var aether: Aether

    override fun onEnable() {
        instance = this
        EventManager.initialize(this)
        //ClassManager.initialize(this)

        //ClassManager.registerPackage("dev.yek4h.hub.listeners", "listener")

        listeners()

        aether = Aether(ScoreboardAdapter(), this, AetherOptions.defaultOptions())

        for (worlds : World in Bukkit.getWorlds()) {
            worlds.setGameRuleValue("showDeathmessages", "false")
            println("Show Death Messages game-rule has been set to FALSE")
            worlds.setGameRuleValue("keepInventory", "true")
            println("Keep Inventory game-rule has been set to TRUE")
            worlds.setGameRuleValue("doMobLoot", "false")
            println("Do Mob Loot game-rule has been set to FALSE")
            worlds.setGameRuleValue("doWeatherCycle", "false")
            println("Do Weather Cycle game-rule has been set to FALSE")
            worlds.setGameRuleValue("doMobSpawning", "false")
            println("Do Mob Spawning game-rule has been set to FALSE")
            worlds.difficulty = Difficulty.PEACEFUL
            worlds.entities.forEach { obj: Entity -> obj.remove() }

        }
    }

    fun listeners() {
        HotbarListener()
        PlayerListener()
        MenuListener()
    }


}