package com.theapache64.cyclone.example.data.remote.login

import com.squareup.moshi.Json
import com.theapache64.cyclone.core.network.BaseApiResponse


class LogInResponse(error: Boolean, message: String, data: Data? = null) :
    BaseApiResponse<LogInResponse.Data>(error, message, data) {

    data class Data(
        @Json(name = "user")
        val user: User
    ) {
        data class User(
            @Json(name = "api_key")
            val apiKey: String, // myApiKey_{randomNumber 10}
            @Json(name = "name")
            val name: String // John Doe
        )
    }
}