package com.krakenlabs.androidbasic.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Alan Giovani Cruz Méndez on 5/1/19 9:07 AM.
 * cruzmendezalan@gmail.com
 */
public class AbstractResponse {
    @SerializedName("success")
    private boolean success;

    @SerializedName("errors")
    private ArrayList<String> errors;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }
}
