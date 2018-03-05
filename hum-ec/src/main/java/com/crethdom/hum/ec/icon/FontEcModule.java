package com.crethdom.hum.ec.icon;
import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;
/**
 * Created by Administrator on 2018/3/2 0002.
 */

public class FontEcModule implements IconFontDescriptor {


    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return EcIcons.values();
    }
}
