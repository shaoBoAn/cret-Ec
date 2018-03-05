package com.crethdom.hum.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by Administrator on 2018/3/5 0005.
 */

public enum EcIcons implements Icon {
    icon_scan('\ue600'),
    icon_ali_pay('\ue600');



    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
