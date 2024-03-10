package dev.yek4h.hub.utils.menu.pagination

import java.util.function.Predicate

class PageFilter<T>(val name: String, private val predicate: Predicate<T>, var isEnabled: Boolean) {
    fun test(t: T): Boolean {
        return !isEnabled || predicate.test(t)
    }

    override fun equals(other: Any?): Boolean {
        return other is PageFilter<*> && other.name == name
    }

}