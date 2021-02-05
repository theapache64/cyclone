package com.theapache64.cyclone.utils

import com.theapache64.cyclone.core.Context
import java.io.File

object JarUtils {

    fun getJarDir(): String {

        val jarDir = File(
            Context::class.java.protectionDomain.codeSource.location
                .toURI()
        ).parent

        if (jarDir.contains("/out/production") || jarDir.contains("/build/classes/")) {
            return ""
        }

        return "$jarDir/"
    }
}
