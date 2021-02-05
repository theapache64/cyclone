package com.theapache64.cyclone.example.di.modules

import com.theapache64.cyclone.core.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule {

    @Provides
    fun provideContext(): Context {
        return Context()
    }
}
