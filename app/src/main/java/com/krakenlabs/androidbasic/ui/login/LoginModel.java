package com.krakenlabs.androidbasic.ui.login;

import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.krakenlabs.androidbasic.ui.basic.BaseModel;

/**
 * Created by Alan Giovani Cruz Méndez on 2019-05-05 13:11.
 * cruzmendezalan@gmail.com
 */
public class LoginModel extends BaseModel {
     String email;
     String password;

    public LoginModel() {
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
