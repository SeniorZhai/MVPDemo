package com.zhai.mvpdemo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by zhai on 16/6/20.
 */

@Singleton
public class Hello {

    @Inject
    public Hello() {
    }

    public String getString() {
        return "hello";
    }
}
