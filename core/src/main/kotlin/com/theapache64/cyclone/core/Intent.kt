package com.theapache64.cyclone.core

import kotlin.reflect.KClass

/**
 * To start an activity
 */
class Intent(
    val to: KClass<out Activity>
) {
    val data = mutableMapOf<String, Any>()
    fun putExtra(key: String, value: Any) {
        data[key] = value
    }

}