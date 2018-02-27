package com.crethdom.hum.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by ShaoboAn on 2018/2/26 0026.
 */

public final class Hum {

    public static Configurator Init(Context context){

        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();

    }

    private static WeakHashMap<String,Object> getConfigurations(){

        return Configurator.getInstance().getHumConfigs();
    }
}
