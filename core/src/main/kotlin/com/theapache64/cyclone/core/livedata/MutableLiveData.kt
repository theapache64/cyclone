package com.theapache64.cyclone.core.livedata

/**
 * Mutable version of LiveData
 */
class MutableLiveData<T>(initValue: T? = null) : LiveData<T>(initValue) {
    public override var value: T?
        get() = super.value
        set(value) {
            super.value = value
        }
}