package com.zhai.mvpdemo

import android.app.Application
import dagger.Component
import javax.inject.Singleton

/**
 * Created by zhai on 16/6/20.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(application: Application)
}
