package com.krakenlabs.androidbasic.components;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alan Giovani Cruz Méndez on 5/1/19 8:56 AM.
 * cruzmendezalan@gmail.com
 */
public abstract class AbstractClient<T> {
    private Retrofit client;
    private static int REQUEST_TIMEOUT = 60;
    private T api;

    public AbstractClient(Context context,String baseUrl) {
        client = new Retrofit
          .Builder()
          .baseUrl(baseUrl)
          .client(initOkhttp(context))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .build();

        api = (T) client.create(getEndpoints());
    }

    private OkHttpClient initOkhttp(Context context) {
        OkHttpClient.Builder httpClient = new OkHttpClient()
          .newBuilder()
          .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
          .readTimeout(REQUEST_TIMEOUT   , TimeUnit.SECONDS)
          .writeTimeout(REQUEST_TIMEOUT  , TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(interceptor);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                  .addHeader("Accept", "application/json")
                  .addHeader("Content-Type", "application/json");

                // Adding Authorization token (API Key)
                // Requests will be denied without API key


                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

         return httpClient.build();
    }

    public abstract Class getEndpoints();

    public T getApi() {
        return api;
    }
}
