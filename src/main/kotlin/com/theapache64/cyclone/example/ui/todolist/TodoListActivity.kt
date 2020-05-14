package com.theapache64.cyclone.example.ui.todolist

import com.theapache64.cyclone.core.Activity
import com.theapache64.cyclone.core.Intent
import com.theapache64.cyclone.core.network.Resource
import com.theapache64.cyclone.example.di.components.DaggerTodoListComponent
import javax.inject.Inject

class TodoListActivity : Activity() {

    companion object {
        private const val KEY_API_KEY = "api_key"
        fun getStartIntent(apiKey: String): Intent {
            return Intent(TodoListActivity::class).apply {
                putExtra(KEY_API_KEY, apiKey)
            }
        }
    }

    @Inject
    lateinit var todoListViewModel: TodoListViewModel

    override fun onCreate() {
        DaggerTodoListComponent.create().inject(this)
        super.onCreate()

        todoListViewModel.todoList.observe {

            when (it.status) {
                Resource.Status.LOADING -> {
                    println("Loading TODO list")
                }

                Resource.Status.SUCCESS -> {
                    println("TODO list loaded")
                    for ((index, todo) in it.data!!.data!!.todoList.withIndex()) {
                        println("${index + 1}) ${todo.title}")
                    }

                    // Ending program
                    finish()
                }

                Resource.Status.ERROR -> {
                    println("Failed to load TODO list : ${it.message!!}")
                }
            }
        }

        val apiKey = getStringExtra(KEY_API_KEY)
        todoListViewModel.init(apiKey)
    }


}