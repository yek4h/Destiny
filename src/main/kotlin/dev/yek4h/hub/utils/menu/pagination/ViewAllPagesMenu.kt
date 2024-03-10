package dev.yek4h.hub.utils.menu.pagination

import dev.yek4h.hub.utils.menu.Button
import dev.yek4h.hub.utils.menu.Menu
import org.bukkit.entity.Player
import java.util.HashMap
import dev.yek4h.hub.utils.menu.button.BackButton

class ViewAllPagesMenu(var menu: PaginatedMenu) : Menu() {
    override fun getTitle(player: Player?): String {
        return "Jump to page"
    }

    override fun getButtons(player: Player?): MutableMap<Int, Button?> {
        val buttons = HashMap<Int, Button?>()
        buttons[0] = BackButton(menu)
        var index = 10
        for (i in 1..menu.getPages(player)) {
            buttons[index++] = JumpToPageButton(i, menu, menu.page == i)
            if ((index - 8) % 9 == 0) {
                index += 2
            }
        }
        return buttons
    }

    override var isAutoUpdate: Boolean
        get() = true
        set(isAutoUpdate) {
            super.isAutoUpdate = isAutoUpdate
        }
}