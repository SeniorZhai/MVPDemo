package com.zhai.mvpdemo;

import com.zhai.mvpdemo.presenter.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhai on 16/6/20.
 */

@Singleton
@Component
public interface HelloComponent {
    void inject(MainActivity activity);
}
