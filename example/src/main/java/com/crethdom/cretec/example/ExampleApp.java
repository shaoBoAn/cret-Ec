package com.crethdom.cretec.example;

import android.app.Application;

import com.crethdom.hum.app.Hum;

/**
 * Created by ShaoboAn on 2018/2/26 0026.
 */

public class ExampleApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Hum.Init(this)
                .withApiHost("http://127.0.0.1")
                .configure();

    }
}
