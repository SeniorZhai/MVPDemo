package com.zhai.mvpdemo.presenter

import com.zhai.mvpdemo.AppComponent
import com.zhai.mvpdemo.utils.ActivityScope
import com.zhai.mvpdemo.view.MainActivity

import dagger.Component

/**
 * Created by zhai on 16/6/22.
 */
@ActivityScope
@Component(modules = arrayOf(MainModule::class), dependencies = arrayOf(AppComponent::class))
interface MainComponent {
    fun inject(mainActivity: MainActivity): MainActivity
}
