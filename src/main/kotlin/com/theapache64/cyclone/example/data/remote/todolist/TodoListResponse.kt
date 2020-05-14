package com.theapache64.cyclone.example.data.remote.todolist

import com.squareup.moshi.Json
import com.theapache64.cyclone.core.network.BaseApiResponse


class TodoListResponse(error: Boolean, message: String, data: Data? = null) :
    BaseApiResponse<TodoListResponse.Data>(error, message, data) {
    data class Data(
        @Json(name = "todo_list")
        val todoList: List<Todo>
    ) {
        data class Todo(
            @Json(name = "desc")
            val desc: String, // Description 1
            @Json(name = "id")
            val id: Int, // 1
            @Json(name = "title")
            val title: String // Title 1
        )
    }
}