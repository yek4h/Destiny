package dev.yek4h.hub.utils.menu.pagination

import dev.yek4h.hub.utils.menu.Button
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

class JumpToPageButton(private val page: Int, private val menu: PaginatedMenu, private val current: Boolean) :
    Button() {
    override fun getButtonItem(player: Player?): ItemStack {
        val itemStack = ItemStack(if (current) Material.ENCHANTED_BOOK else Material.BOOK, page)
        val itemMeta = itemStack.itemMeta
        itemMeta.displayName = ChatColor.YELLOW.toString() + "Page " + page
        if (current) {
            itemMeta.lore = listOf(
                "", ChatColor.GREEN.toString() + "Current page"
            )
        }
        itemStack.itemMeta = itemMeta
        return itemStack
    }

    override fun clicked(player: Player?, clickType: ClickType?) {
        menu.modPage(player, page - menu.page)
        playNeutral(player!!)
    }
}