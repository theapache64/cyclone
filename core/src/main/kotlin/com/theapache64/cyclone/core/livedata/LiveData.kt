package com.theapache64.cyclone.core.livedata

/**
 * iLiveData is an observable data holder class.
 */
open class LiveData<T> protected constructor(
    initValue: T? = null
) {

    private val observers = mutableListOf<(t: T) -> Unit>()

    protected open var value: T? = null
        protected set(value) {
            field = value
            if (field != null) {
                // notify observer
                observers.forEach { observer ->
                    observer(field!!)
                }
            }
        }

    init {
        if (initValue != null) {
            this.value = initValue
        }
    }

    /**
     * To observe for value change
     */
    fun observe(observer: (t: T) -> Unit) {

        if (value != null) {
            // notifying last value
            observer(value!!)
        }

        // adding to observers for future updates
        observers.add(observer)
    }

    fun <X> map(function: (t: T) -> X): LiveData<X> {
        val mapLiveData = MutableLiveData<X>()

        if (value != null) {
            mapLiveData.value = function(value!!)
        }

        observers.add {
            // value changed
            mapLiveData.value = function(it)
        }

        return mapLiveData
    }

    fun <X> switchMap(function: (request: T, response: MutableLiveData<X>) -> Unit): LiveData<X> {

        val mapLiveData = MutableLiveData<X>()

        if (value != null) {
            function(value!!, mapLiveData)
        }

        observers.add {
            // value changed
            function(it, mapLiveData)
        }

        return mapLiveData
    }
}