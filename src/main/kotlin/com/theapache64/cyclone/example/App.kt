package com.theapache64.cyclone.example

import com.theapache64.cyclone.core.Application
import com.theapache64.cyclone.example.ui.login.LogInActivity
import kotlinx.coroutines.runBlocking

/**
 * Application class
 */
class App : Application() {

    override suspend fun onCreate() {
        super.onCreate()

        val logInIntent = LogInActivity.getStartIntent()
        startActivity(logInIntent)
    }
}

/**
 * Entry point
 */
@Suppress("UNUSED_PARAMETER")
fun main(args: Array<String>) = runBlocking {
    App().onCreate()
}