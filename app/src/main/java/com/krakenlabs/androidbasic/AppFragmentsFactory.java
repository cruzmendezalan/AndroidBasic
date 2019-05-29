package com.krakenlabs.androidbasic;

import com.krakenlabs.androidbasic.ui.basic.FragmentsFactory;
import com.krakenlabs.androidbasic.ui.login.WMLoginFragment;

import java.util.HashMap;

/**
 * Created by Alan Giovani Cruz Méndez on 2019-05-29 12:30.
 * cruzmendezalan@gmail.com
 */
public class AppFragmentsFactory extends FragmentsFactory {

    @Override
    public WMLoginFragment getLoginFrsgment(HashMap params) {
        //si requieren parametros para inflar el fragmento se toman del hashmap
        return new WMLoginFragment();
    }
}
