package com.krakenlabs.androidbasic.ui.activity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

/**
 * Created by Alan Giovani Cruz Méndez on 2019-05-29 10:00.
 * cruzmendezalan@gmail.com
 */
public class ActivityModel extends BaseObservable {
    private static final String TAG = "WMActivityModel";
    private boolean loadingProfile;
    private boolean sessionActive;

    private String email;
    private String labelButtonLogin;
    private String labelHeader;

    @Bindable
    public String getLabelButtonLogin() {
        return labelButtonLogin;
    }

    public void setLabelButtonLogin(String labelButtonLogin) {
        this.labelButtonLogin = labelButtonLogin;
        notifyPropertyChanged(BR.labelButtonLogin);
    }

    public boolean isLoadingProfile() {
        return loadingProfile;
    }

    public void setLoadingProfile(boolean loadingProfile) {
        this.loadingProfile = loadingProfile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Bindable
    public boolean isSessionActive() {
        return sessionActive;
    }

    @Bindable
    public String getLabelHeader() {
        return labelHeader;
    }

    public void setLabelHeader(String labelHeader) {
        this.labelHeader = labelHeader;
        notifyPropertyChanged(BR.labelHeader);
    }

    public void setSessionActive(boolean sessionActive) {
        this.sessionActive = sessionActive;
        notifyPropertyChanged(BR.sessionActive);
    }
}
