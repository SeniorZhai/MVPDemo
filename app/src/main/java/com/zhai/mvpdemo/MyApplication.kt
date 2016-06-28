package com.zhai.mvpdemo

import android.app.Application
import android.content.Context

/**
 * Created by zhai on 16/6/20.
 */
class MyApplication : Application() {
    // 延迟初始化
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        @JvmStatic
        fun getComponent(context: Context): AppComponent {
            val app = context.applicationContext as MyApplication
            return app.appComponent
        }
    }
}

