package com.zhai.mvpdemo.presenter

import com.zhai.mvpdemo.model.MainModel
import com.zhai.mvpdemo.utils.ActivityScope
import com.zhai.mvpdemo.view.MainActivity

import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by zhai on 16/6/22.
 */
@Module
class MainModule(private val mainActivity: MainActivity) {
    private val mainModel: MainModel

    init {
        mainModel = MainModel()
    }

    @Provides
    @ActivityScope
    internal fun provideMainActivity(): MainActivity {
        return mainActivity
    }

    @Provides
    @ActivityScope
    @Named("presenter")
    internal fun providePresenter(): MainPresenter {
        return MainPresenter(mainActivity, mainModel)
    }

    @Provides
    @ActivityScope
    @Named("model")
    internal fun provideModel(): MainModel {
        return mainModel
    }
}
