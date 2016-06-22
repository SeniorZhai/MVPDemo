package com.zhai.mvpdemo.view;

import com.zhai.mvpdemo.model.MainModel;
import com.zhai.mvpdemo.presenter.MainActivity;
import com.zhai.mvpdemo.presenter.MainPresenter;
import com.zhai.mvpdemo.utils.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhai on 16/6/22.
 */
@Module
public class MainActivityModule {
    private MainActivity mainActivity;
    private MainModel mainModel;

    public MainActivityModule(MainActivity mainActivity, MainModel mainModel) {
        this.mainActivity = mainActivity;
        this.mainModel = mainModel;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainPresenter providePresenter() {
        return new MainPresenter(mainActivity, mainModel);
    }
}
