package com.theapache64.cyclone.core

/**
 * Application class (entry point)
 */
open class Application  {

    protected suspend fun startActivity(intent: Intent) {
        val activity = intent.to.java.newInstance()
        activity.intent = intent
        activity.onCreate()
    }

    open suspend fun onCreate() {

    }
}