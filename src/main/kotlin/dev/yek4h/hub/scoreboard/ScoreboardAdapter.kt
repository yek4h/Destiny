package dev.yek4h.hub.scoreboard

import dev.t4yrn.yek4h.scoreboard.board.Board
import dev.t4yrn.yek4h.scoreboard.board.BoardAdapter
import dev.t4yrn.yek4h.scoreboard.board.cooldown.BoardCooldown
import dev.t4yrn.yek4h.util.UnicodeUtil
import dev.txnio.samurai.util.CC
import land.combo.darling.spigot.Darling
import land.combo.darling.spigot.profile.Profile
import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.scoreboard.Scoreboard
import java.util.*

class ScoreboardAdapter: BoardAdapter {

    override fun getTitle(player: Player): String {
        val data: Profile = Darling.getInstance().profiles.getOrCreate(player.uniqueId)
        val color = (if (data.serverColor.color != null) data.serverColor.color else ChatColor.AQUA)
        return CC.translate("$color &lSwimp Network");
    }

    override fun getScoreboard(player: Player, board: Board, cooldowns: Set<BoardCooldown>): List<String> {
        val list: MutableList<String> = LinkedList()

        val data: Profile = Darling.getInstance().profiles.getOrCreate(player.uniqueId)
        val color = (if (data.serverColor.color != null) data.serverColor.color else ChatColor.AQUA)
        val rank = (if (data.highestRank.color != null) data.highestRank.color else ChatColor.GREEN).toString() + (if (data.highestRank.name != null) data.highestRank.name else "Default")

        list.add("&7&m--------------------")
        list.add("$color" + "Online Players:")
        list.add(("&f " + (PlaceholderAPI.setPlaceholders(player, "%bungee_total%"))) + "&7/&f1,200")
        list.add("")
        list.add("$color" + "You:")
        list.add("$color ► Rank&7: $color$rank")
        list.add("$color ► Coins&7: &f" + data.coins + UnicodeUtil.COINS)
        list.add("")
        list.add("&7    &7    &7" + "swimp.life")
        list.add("&7&m--------------------")
        return CC.translate(list)
    }

    override fun onScoreboardCreate(player: Player, board: Scoreboard) {
    }
}