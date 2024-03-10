package dev.yek4h.hub.utils.menu.menus

import dev.yek4h.hub.utils.menu.Button
import dev.yek4h.hub.utils.menu.Menu
import dev.t4yrn.yek4h.menu.button.ConfirmationButton
import dev.t4yrn.yek4h.util.callback.TypeCallback
import org.bukkit.entity.Player

class ConfirmMenu(
    private val title: String,
    private val response: TypeCallback<Boolean>,
    private val closeAfterResponse: Boolean,
    private val centerButtons: Array<Button?>?
) : Menu() {
    override fun getButtons(player: Player?): MutableMap<Int, Button?> {
        val buttons = HashMap<Int, Button?>()
        for (x in 0..2) {
            for (y in 0..2) {
                buttons[getSlot(x, y)] = ConfirmationButton(true, response, closeAfterResponse)
                buttons[getSlot(8 - x, y)] = ConfirmationButton(false, response, closeAfterResponse)
            }
        }
        if (centerButtons != null) {
            for (i in centerButtons.indices) {
                if (centerButtons[i] != null) {
                    buttons[getSlot(4, i)] = centerButtons[i]
                }
            }
        }
        return buttons
    }

    override fun getTitle(player: Player?): String? {
        return title
    }
}