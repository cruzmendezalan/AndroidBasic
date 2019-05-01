package com.krakenlabs.androidbasic.models.search.request;

import com.krakenlabs.androidbasic.models.AbstractRequest;

/**
 * Created by Alan Giovani Cruz Méndez on 5/1/19 2:52 PM.
 * cruzmendezalan@gmail.com
 */
public class RequestSearch extends AbstractRequest{

    private String Ntt;
    private String Nrpp;
    private String offSet;
    private String storeId;


    public String getNtt() {
        return Ntt;
    }

    public void setNtt(String ntt) {
        Ntt = ntt;
    }

    public String getNrpp() {
        return Nrpp;
    }

    public void setNrpp(String nrpp) {
        Nrpp = nrpp;
    }

    public String getOffSet() {
        return offSet;
    }

    public void setOffSet(String offSet) {
        this.offSet = offSet;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
}
