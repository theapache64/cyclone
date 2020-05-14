package com.theapache64.cyclone.example

import com.theapache64.cyclone.core.Application
import com.theapache64.cyclone.example.ui.login.LogInActivity

/**
 * Application class
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val logInIntent = LogInActivity.getStartIntent()
        startActivity(logInIntent)
    }
}

/**
 * Entry point
 */
fun main(args: Array<String>) {
    App().onCreate()
}