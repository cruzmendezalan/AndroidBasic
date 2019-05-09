package com.krakenlabs.androidbasic.providers;

import com.krakenlabs.androidbasic.models.AbstractRequest;
import com.krakenlabs.androidbasic.models.AbstractResponse;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Completable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


/**
 * Created by Alan Giovani Cruz Méndez on 5/1/19 1:37 PM.
 * cruzmendezalan@gmail.com
 */
public interface ApiServices {
    // GET
    @GET
    Completable getRequest(@Url String endpoint, @QueryMap Map<String, String> params);

    @POST
    Completable postRequest(@Url String endpoint, @QueryMap Map<String, String> params);
}
