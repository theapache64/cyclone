package com.theapache64.cyclone.example.ui.login

import com.theapache64.cyclone.core.extensions.asLiveData
import com.theapache64.cyclone.core.livedata.LiveData
import com.theapache64.cyclone.core.livedata.MutableLiveData
import com.theapache64.cyclone.core.network.Resource
import com.theapache64.cyclone.example.data.remote.login.LogInRequest
import com.theapache64.cyclone.example.data.remote.login.LogInResponse
import com.theapache64.cyclone.example.data.repositories.PrefRepo
import com.theapache64.cyclone.example.data.repositories.UserRepo
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class LogInViewModel @Inject constructor(
    private val userRepo: UserRepo,
    private val prefRepo: PrefRepo
) {

    private val _credentialPrompt = MutableLiveData<Boolean>()
    val credentialPrompt: LiveData<Boolean> = _credentialPrompt

    private val _startTodo = MutableLiveData<String>()
    val startTodo: LiveData<String> = _startTodo

    private val _openCount = MutableLiveData<Int>()
    val openCount: LiveData<Int> = _openCount

    private val logInRequest = MutableLiveData<LogInRequest>()
    val logInResponse: LiveData<Resource<LogInResponse>> = logInRequest.switchMap { logInRequest, logInResponse ->
        userRepo.logIn(logInRequest)
            .onEach {
                if (it.status == Resource.Status.SUCCESS) {
                    _startTodo.value = it.data!!.data!!.user.apiKey
                }
            }
            .asLiveData(logInResponse)
    }

    init {
        _openCount.value = prefRepo.getOpenCount()
        prefRepo.incrementOpenCount()
    }

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    fun performLogIn(username: String, password: String) {

        if (username.isNotBlank() && password.isNotBlank()) {
            // valid username
            this.logInRequest.value = LogInRequest(username, password)
        } else {
            // invalid username
            _msg.value = "Username and password can't be empty."
            _credentialPrompt.value = true
        }
    }

    init {
        _credentialPrompt.value = true
    }

}