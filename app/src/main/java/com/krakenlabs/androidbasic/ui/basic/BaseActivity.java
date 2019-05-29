package com.krakenlabs.androidbasic.ui.basic;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Alan Giovani Cruz Méndez on 2019-05-29 12:02.
 * cruzmendezalan@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * Agregar un fragmento a la pila
     * @param fragment
     * @param <T>
     */
    public abstract <T extends BaseFragment> void addFragment(T fragment);

    /**
     * Remplazar un fragmento en la pila, removiendo los existentes
     * @param fragment
     * @param <T>
     */
    public abstract <T extends BaseFragment> void replaceFragment(T fragment);

    public abstract <T extends FragmentsFactory> T getFragmentFactory();
}
