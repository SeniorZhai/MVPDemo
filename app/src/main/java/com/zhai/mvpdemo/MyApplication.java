package com.zhai.mvpdemo;

import android.app.Application;

/**
 * Created by zhai on 16/6/20.
 */
public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

