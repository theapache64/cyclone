package com.theapache64.cyclone.example.data.remote

import com.theapache64.cyclone.core.network.Resource
import com.theapache64.cyclone.example.data.remote.login.LogInRequest
import com.theapache64.cyclone.example.data.remote.login.LogInResponse
import com.theapache64.cyclone.example.data.remote.todolist.TodoListResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

    @POST("login")
    fun logIn(
        @Body logInRequest: LogInRequest
    ): Flow<Resource<LogInResponse>>

    @GET("get_todo_list")
    fun getTodoList(
        @Header("Authorization") apiKey: String
    ): Flow<Resource<TodoListResponse>>
}