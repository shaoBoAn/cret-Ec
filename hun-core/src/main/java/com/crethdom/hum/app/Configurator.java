package com.crethdom.hum.app;

import java.util.WeakHashMap;

/**
 * Created by ShaoboAn on 2018/2/26 0026.
 */

public class Configurator {

    private static final WeakHashMap<String,Object> HUM_CONFIG = new WeakHashMap<>();

    private Configurator(){

        HUM_CONFIG.put(ConfigType.CONFIG_READY.name(),false);
    }

    private static class Holder{

        private static final Configurator INSTANCE = new Configurator();

    }

    public final void configure(){

        HUM_CONFIG.put(ConfigType.CONFIG_READY.name(),true);
    }

    public static Configurator getInstance(){

        return Holder.INSTANCE;
    }

    final WeakHashMap<String,Object> getHumConfigs(){

        return HUM_CONFIG;
    }

    public final Configurator withApiHost(String host){

        HUM_CONFIG.put(ConfigType.API_HOST.name(),host);
        return this;

    }

    private void checkConfiguration(){

        final boolean isReady = (boolean) HUM_CONFIG.get(ConfigType.CONFIG_READY.name());

        if(!isReady){

            throw new RuntimeException("configuration is not ready, pelase call configure!");
        }

    }

    @SuppressWarnings("unchecked")

    final <T> T getConfiguration(Enum<ConfigType> key){

        checkConfiguration();
        return (T)HUM_CONFIG.get(key.name());

    }

}
