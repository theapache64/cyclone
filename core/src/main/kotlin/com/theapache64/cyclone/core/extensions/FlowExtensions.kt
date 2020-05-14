package com.theapache64.cyclone.core.extensions

import com.theapache64.cyclone.core.livedata.MutableLiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

/**
 * To convert Flow to LiveData
 */
fun <T> Flow<T>.asLiveData(resultLiveData: MutableLiveData<T>) {
    runBlocking {
        collect {
            resultLiveData.value = it
        }
    }
}