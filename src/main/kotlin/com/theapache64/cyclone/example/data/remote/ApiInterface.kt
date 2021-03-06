package com.theapache64.cyclone.example.data.remote

import com.theapache64.cyclone.core.network.Resource
import com.theapache64.cyclone.example.data.remote.login.LogInResponse
import com.theapache64.cyclone.example.data.remote.todolist.TodoListResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiInterface {

    @GET("login.json")
    fun logIn(): Flow<Resource<LogInResponse>>

    @GET("todo_list.json")
    fun getTodoList(): Flow<Resource<TodoListResponse>>
}