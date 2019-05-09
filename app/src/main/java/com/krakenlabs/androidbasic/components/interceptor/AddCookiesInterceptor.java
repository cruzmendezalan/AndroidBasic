package com.krakenlabs.androidbasic.components.interceptor;

import java.io.IOException;
import java.util.HashSet;
import java.util.prefs.Preferences;


import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Alan Giovani Cruz Méndez on 5/1/19 3:50 PM.
 * cruzmendezalan@gmail.com
 */
public class AddCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder     = chain.request().newBuilder();

//        HashSet<String> preferences = (HashSet) Preferences.getDefaultPreferences().getStringSet(Preferences.PREF_COOKIES, new HashSet<>());
//
//        for (String cookie : preferences) {
//            builder.addHeader("Cookie", cookie);
//
//        }

        return chain.proceed(builder.build());
    }
}
