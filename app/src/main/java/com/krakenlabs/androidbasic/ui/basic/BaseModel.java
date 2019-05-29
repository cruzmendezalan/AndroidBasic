package com.krakenlabs.androidbasic.ui.basic;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

/**
 * Created by Alan Giovani Cruz Méndez on 2019-05-29 12:16.
 * cruzmendezalan@gmail.com
 */
public class BaseModel extends BaseObservable {
    private boolean isBusy = false;/*bloqueo de UI*/
    private int     code;/*si se desea manejar un código*/
    private String  msg; /*si se desea colocar un mensahe */

    @Bindable
    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
        notifyPropertyChanged(BR.busy);
    }

    @Bindable
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Bindable
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
