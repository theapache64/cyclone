package com.theapache64.cyclone.core.base


import com.theapache64.cyclone.core.InputUtils
import kotlinx.coroutines.delay
import java.util.concurrent.Callable

abstract class BaseCommand<T>(
    private val isFromTest: Boolean
) : Callable<T> {

    suspend fun chooseIndex(items: List<String>): Int {

        println("Choose: ")

        items.forEachIndexed() { index: Int, string: String ->
            println("${index + 1}) $string")
        }

        @Suppress("ConstantConditionIf")
        return if (isFromTest) {
            delay(1000)
            0
        } else {
            InputUtils.getInt("Choose one", 1, items.size) - 1
        }
    }
}