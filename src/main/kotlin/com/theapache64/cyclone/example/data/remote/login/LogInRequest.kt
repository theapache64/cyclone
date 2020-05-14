package com.theapache64.cyclone.example.data.remote.login

import com.squareup.moshi.Json

data class LogInRequest(
    @Json(name = "username")
    val username: String, // john
    @Json(name = "password")
    val password: String // pass123
)