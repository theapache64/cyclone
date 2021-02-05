package com.theapache64.cyclone.example.ui.login

import com.theapache64.cyclone.core.Activity
import com.theapache64.cyclone.core.Intent
import com.theapache64.cyclone.core.network.Resource
import com.theapache64.cyclone.example.di.components.DaggerLogInComponent
import com.theapache64.cyclone.example.ui.todolist.TodoListActivity
import javax.inject.Inject
import kotlin.system.exitProcess

class LogInActivity : Activity() {

    companion object {
        fun getStartIntent(): Intent {
            return Intent(LogInActivity::class).apply {
            }
        }
    }

    @Inject
    lateinit var logInViewModel: LogInViewModel

    override fun onCreate() {
        DaggerLogInComponent.create().inject(this)
        super.onCreate()

        // Watching for login purpose
        logInViewModel.openCount.observe {
            println("OpenCount: $it")
        }

        logInViewModel.logInResponse.observe {
            when (it.status) {

                Resource.Status.LOADING -> {
                    println("Logging in...")
                }

                Resource.Status.ERROR -> {
                    println("Failed to login : ${it.message}")
                    exitProcess(0)
                }
                else -> {
                    // Success handled in ViewModel
                }
            }
        }

        logInViewModel.credentialPrompt.observe {

            val username = promptString("Username")
            val password = promptString("Password")

            logInViewModel.performLogIn(username, password)
        }

        logInViewModel.startTodo.observe { apiKey ->
            val todoListIntent = TodoListActivity.getStartIntent(apiKey)
            startActivity(todoListIntent)
        }

        logInViewModel.msg.observe { message ->
            println(message)
        }
    }


}