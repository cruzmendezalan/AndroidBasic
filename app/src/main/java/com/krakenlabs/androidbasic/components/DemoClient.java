package com.krakenlabs.androidbasic.components;

import android.content.Context;

import com.krakenlabs.androidbasic.providers.ApiServices;

/**
 * Created by Alan Giovani Cruz Méndez on 5/1/19 2:04 PM.
 * cruzmendezalan@gmail.com
 */
public class DemoClient extends AbstractClient{

    public DemoClient(Context context, String baseUrl) {
        super(context, baseUrl);
    }

    @Override
    public Class getEndpoints() {
        return ApiServices.class;
    }

    @Override
    public ApiServices getApi() {
        return (ApiServices) super.getApi();
    }
}
