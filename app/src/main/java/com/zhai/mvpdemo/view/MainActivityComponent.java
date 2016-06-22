package com.zhai.mvpdemo.view;

import com.zhai.mvpdemo.AppComponent;
import com.zhai.mvpdemo.presenter.MainActivity;
import com.zhai.mvpdemo.utils.ActivityScope;

import dagger.Component;

/**
 * Created by zhai on 16/6/22.
 */
@ActivityScope
@Component(modules = MainActivityModule.class, dependencies = AppComponent.class)
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);
}
