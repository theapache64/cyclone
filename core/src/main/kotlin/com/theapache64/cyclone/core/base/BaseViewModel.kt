package com.theapache64.cyclone.core.base

abstract class BaseViewModel<T> {
    abstract suspend fun call(command: T): Int
}