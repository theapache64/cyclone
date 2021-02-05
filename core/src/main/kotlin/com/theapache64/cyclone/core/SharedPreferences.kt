package com.theapache64.cyclone.core

import com.theapache64.cyclone.utils.JarUtils
import org.json.JSONObject
import java.io.File

class SharedPreferences(
    private val name: String
) {
    private val prefFile by lazy {
        File("${JarUtils.getJarDir()}$name.json")
    }

    fun getBoolean(key: String, default: Boolean?): Boolean? {
        val joRoot = getPrefRoot()
        return if (joRoot.has(key)) {
            joRoot.getBoolean(key)
        } else {
            default
        }
    }

    fun getString(key: String, default: String?): String? {
        val joRoot = getPrefRoot()
        return if (joRoot.has(key)) {
            joRoot.getString(key)
        } else {
            default
        }
    }

    fun putString(key: String, value: String?) {
        val joRoot = getPrefRoot()
        joRoot.put(key, value)
        prefFile.writeText(joRoot.toString())
    }

    fun putBoolean(key: String, value: Boolean?) {
        val joRoot = getPrefRoot()
        joRoot.put(key, value)
        prefFile.writeText(joRoot.toString())
    }

    private fun getPrefRoot(): JSONObject {
        val jsonString = if (prefFile.exists()) {
            val content = prefFile.readText()
            if (content.isNotEmpty()) {
                content
            } else {
                null
            }
        } else {
            null
        } ?: "{}"

        return JSONObject(jsonString)
    }
}