package com.theapache64.cyclone.example.ui.todolist

import com.theapache64.cyclone.core.extensions.asLiveData
import com.theapache64.cyclone.core.livedata.LiveData
import com.theapache64.cyclone.core.livedata.MutableLiveData
import com.theapache64.cyclone.core.network.Resource
import com.theapache64.cyclone.example.data.remote.todolist.TodoListRequest
import com.theapache64.cyclone.example.data.remote.todolist.TodoListResponse
import com.theapache64.cyclone.example.data.repositories.TodoRepo
import com.theapache64.cyclone.example.data.repositories.UserRepo
import javax.inject.Inject

class TodoListViewModel @Inject constructor(
    private val todoRepo: TodoRepo,
    userRepo: UserRepo
) {

    private val _todoListRequest = MutableLiveData<TodoListRequest>()
    val todoList: LiveData<Resource<TodoListResponse>> = _todoListRequest.switchMap { request, response ->
        todoRepo.getTodoList(request.apiKey).asLiveData(response)
    }

    fun init(apiKey: String) {
        _todoListRequest.value = TodoListRequest(apiKey)
    }
}