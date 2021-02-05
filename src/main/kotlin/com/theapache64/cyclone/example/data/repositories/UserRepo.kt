package com.theapache64.cyclone.example.data.repositories

import com.theapache64.cyclone.example.data.remote.ApiInterface
import com.theapache64.cyclone.example.data.remote.login.LogInRequest
import javax.inject.Inject

class UserRepo @Inject constructor(
    private val apiInterface: ApiInterface
) {

    /**
     * We're purposely not using logInRequest, because we're using raw JSON for the response.
     */
    fun logIn(logInRequest: LogInRequest) = apiInterface.logIn()
}