package com.crethdom.hum.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by ShaoboAn on 2018/2/26 0026.
 */

public class Configurator {

    private static final HashMap<String,Object> HUM_CONFIG = new HashMap<>();

    private static final ArrayList<IconFontDescriptor> ICON = new ArrayList<>();

    private Configurator(){

        HUM_CONFIG.put(ConfigType.CONFIG_READY.name(),false);
    }

    private static class Holder{

        private static final Configurator INSTANCE = new Configurator();

    }

    public final void configure(){
        initIcons();
        HUM_CONFIG.put(ConfigType.CONFIG_READY.name(),true);
    }

    public static Configurator getInstance(){

        return Holder.INSTANCE;
    }

    final HashMap<String,Object> getHumConfigs(){

        return HUM_CONFIG;
    }

    public final Configurator withApiHost(String host){

        HUM_CONFIG.put(ConfigType.API_HOST.name(),host);
        return this;

    }

    private void initIcons(){

        if(ICON.size()>0) {

            final Iconify.IconifyInitializer initializer = Iconify.with(ICON.get(0));
            for(int i=1;i<ICON.size();i++){
                initializer.with(ICON.get(i));
            }
        }
    }

    public final Configurator withIcons(IconFontDescriptor descriptor){

        ICON.add(descriptor);
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
