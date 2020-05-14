package com.theapache64.cyclone.example.di.components

import com.theapache64.cyclone.example.di.modules.NetworkModule
import com.theapache64.cyclone.example.ui.todolist.TodoListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface TodoListComponent {
    fun inject(todoListActivity: TodoListActivity)
}