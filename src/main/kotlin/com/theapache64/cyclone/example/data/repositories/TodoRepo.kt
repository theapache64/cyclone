package com.theapache64.cyclone.example.data.repositories

import com.theapache64.cyclone.example.data.remote.ApiInterface
import javax.inject.Inject

class TodoRepo @Inject constructor(
    private val apiInterface: ApiInterface
) {
    fun getTodoList(apiKey: String) = apiInterface.getTodoList(apiKey)
}