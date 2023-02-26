package com.theapache64.cyclone.core

import kotlin.system.exitProcess

/**
 * Base activity for every activity
 */
open class Activity : Context() {

    /**
     * To start a new activity
     */
    protected suspend fun startActivity(intent: Intent) {
        val activity = intent.to.java.newInstance()
        activity.intent = intent
        onDestroy()
        activity.onCreate()
    }

    lateinit var intent: Intent

    /**
     * Called when activity started
     */
    open suspend fun onCreate() {
    }

    /**
     * Called when activity finished or a new activity started
     */
    open fun onDestroy() {
    }

    /**
     * To get string data from intent.
     */
    protected fun getStringExtra(key: String): String {
        return intent.data[key] as String
    }

    /**
     * To get string input from console
     */
    protected fun promptString(prompt: String, isRequired: Boolean = true): String {
        return InputUtils.getString(prompt, isRequired)
    }

    /**
     * To finish the program
     */
    protected fun finish() {
        onDestroy()
        exitProcess(0)
    }
}