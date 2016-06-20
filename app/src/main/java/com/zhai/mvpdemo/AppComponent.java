package com.zhai.mvpdemo;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhai on 16/6/20.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(Application application);
}
