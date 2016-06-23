package com.zhai.mvpdemo

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by zhai on 16/6/20.
 */
@Module
class AppModule(private val application: MyApplication) {

    @Provides
    @Singleton
    @Named("application")
    internal fun providesApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    @Named("context")
    internal fun providesContext(): Context {
        return application.baseContext
    }
}
