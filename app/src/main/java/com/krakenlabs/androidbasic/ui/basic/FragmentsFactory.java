package com.krakenlabs.androidbasic.ui.basic;

import java.util.HashMap;

/**
 * Created by Alan Giovani Cruz Méndez on 2019-05-29 12:05.
 * cruzmendezalan@gmail.com
 */
public abstract class FragmentsFactory {
    public abstract <T extends BaseFragment> T getLoginFrsgment(HashMap params);
}
