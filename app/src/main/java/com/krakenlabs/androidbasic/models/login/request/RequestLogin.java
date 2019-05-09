package com.krakenlabs.androidbasic.models.login.request;

import com.google.gson.annotations.SerializedName;
import com.krakenlabs.androidbasic.models.AbstractRequest;

/**
 * Created by Alan Giovani Cruz Méndez on 5/1/19 9:12 AM.
 * cruzmendezalan@gmail.com
 */
public class RequestLogin extends AbstractRequest {
    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public RequestLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
