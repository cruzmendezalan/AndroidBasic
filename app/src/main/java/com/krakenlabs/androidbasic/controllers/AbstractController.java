package com.krakenlabs.androidbasic.controllers;

import android.content.Context;

import com.krakenlabs.androidbasic.components.AbstractClient;

/**
 * Created by Alan Giovani Cruz Méndez on 5/1/19 8:55 AM.
 * cruzmendezalan@gmail.com
 * Controlador de negocio
 */
public abstract class AbstractController {
    private AbstractClient client;

    public AbstractController(Context context) {
        client = initClient(context);
    }

    public abstract <T extends AbstractClient> T initClient(Context context);

    public <T extends AbstractClient> T getClient() {
        return (T) client;
    }
}
