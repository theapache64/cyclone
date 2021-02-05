package com.theapache64.cyclone.example.di.modules

import com.theapache64.cyclone.core.Context
import com.theapache64.cyclone.core.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class PrefModule {

    @Singleton
    @Provides
    fun providePref(context: Context): SharedPreferences {
        return context.getSharedPreferences("cyclone_demo_pref")
    }
}