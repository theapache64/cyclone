package com.theapache64.cyclone.core

open class Context {

    fun getSharedPreferences(name: String): SharedPreferences {
        return SharedPreferences(name)
    }
}