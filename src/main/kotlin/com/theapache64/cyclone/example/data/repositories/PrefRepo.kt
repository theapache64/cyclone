package com.theapache64.cyclone.example.data.repositories

import com.theapache64.cyclone.core.SharedPreferences
import javax.inject.Inject

class PrefRepo @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    companion object {
        private const val KEY_OPEN_COUNT = "open_count"
    }

    fun getOpenCount(): Int {
        return sharedPreferences.getString(KEY_OPEN_COUNT, null)?.toInt() ?: 0
    }

    fun incrementOpenCount() {
        val newOpenCount = getOpenCount() + 1
        sharedPreferences.putString(KEY_OPEN_COUNT, newOpenCount.toString())
    }
}