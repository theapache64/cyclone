package com.theapache64.cyclone.example.di.components

import com.theapache64.cyclone.example.di.modules.NetworkModule
import com.theapache64.cyclone.example.di.modules.PrefModule
import com.theapache64.cyclone.example.ui.login.LogInActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, PrefModule::class])
interface LogInComponent {
    fun inject(activity: LogInActivity)
}