package com.theapache64.cyclone.example.data.repositories

import com.theapache64.cyclone.example.data.remote.ApiInterface
import javax.inject.Inject

class TodoRepo @Inject constructor(
    private val apiInterface: ApiInterface
) {
    /**
     * We're purposely not using apiKey, because we're using raw JSON for the response.
     */
    fun getTodoList(apiKey: String) = apiInterface.getTodoList()
}