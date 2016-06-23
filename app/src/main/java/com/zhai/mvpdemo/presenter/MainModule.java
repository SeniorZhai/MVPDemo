package com.zhai.mvpdemo.presenter;

import com.zhai.mvpdemo.model.MainModel;
import com.zhai.mvpdemo.utils.ActivityScope;
import com.zhai.mvpdemo.view.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhai on 16/6/22.
 */
@Module
public class MainModule {
    private MainActivity mainActivity;
    private MainModel mainModel;

    public MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        mainModel = new MainModel();
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

    @Provides
    @ActivityScope
    MainModel provideModel() {
        return mainModel;
    }
}
