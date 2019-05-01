package com.krakenlabs.androidbasic.providers;

import com.krakenlabs.androidbasic.models.AbstractRequest;
import com.krakenlabs.androidbasic.models.AbstractResponse;

import java.util.Map;

import io.reactivex.Completable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Alan Giovani Cruz Méndez on 5/1/19 1:37 PM.
 * cruzmendezalan@gmail.com
 */
public interface ApiServices<T extends AbstractResponse, Q extends AbstractRequest> {
    // GET
    @GET
    Completable getRequest(@Url String endpoint, @QueryMap Map<String, String> params);
}
