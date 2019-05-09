package com.krakenlabs.androidbasic.controllers;

import android.content.Context;
import android.util.Log;

import com.krakenlabs.androidbasic.BuildConfig;
import com.krakenlabs.androidbasic.components.AbstractClient;
import com.krakenlabs.androidbasic.components.DemoClient;
import com.krakenlabs.androidbasic.models.login.request.RequestLogin;
import com.krakenlabs.androidbasic.models.search.request.RequestSearch;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alan Giovani Cruz Méndez on 5/1/19 2:20 PM.
 * cruzmendezalan@gmail.com
 */
public class Controller extends AbstractController {
    private static final String TAG = "Controller";
    public Controller(Context context) {
        super(context);
    }

    @Override
    public <T extends AbstractClient> T initClient(Context context) {
        return (T) new DemoClient(context, BuildConfig.endpoint);
    }


    public void login(String param){

//        RequestLogin lo = new RequestLogin();
//
//        getClient()
//          .getApi()
//          .getRequest(BuildConfig.endpoint, new HashMap<String, String>())
//          .subscribeOn(Schedulers.io())
//          .observeOn(Schedulers.io())
//          .toObservable()
//          .map(new Function() {
//              @Override
//              public Object apply(Object o) throws Exception {
//                  return o;
//              }
//          })
//          .subscribeWith(new DisposableObserver() {
//              @Override
//              public void onNext(Object value) {
//                  //operations in background thread
//                  Log.d(TAG, "onNext() called with: value = [" + value + "]");
//              }
//
//              @Override
//              public void onError(Throwable e) {
//                  // if something going wrong
//              }
//
//              @Override
//              public void onComplete() {
//
//              }
//          });
    }

    public void search(){
        RequestSearch re = new RequestSearch();
        re.setNtt("leche");
        re.setNrpp("20");
        re.setStoreId("0000009999");
        re.setOffSet("0");

        getClient()
          .getApi()
          .getRequest(BuildConfig.endpoint+"/api/wmx/search/",re.toMap())
          .subscribeOn(Schedulers.io())
          .observeOn(Schedulers.io())
          .toObservable()
          .map(new Function() {
              @Override
              public Object apply(Object o) throws Exception {
                  return o;
              }
          })
          .subscribeWith(new DisposableObserver() {
              @Override
              public void onNext(Object value) {
                  //operations in background thread
                  Log.e(TAG, "onNext() called with: value = [" + value + "]");
              }

              @Override
              public void onError(Throwable e) {
                  // if something going wrong
                  Log.e(TAG, "onError() called with: e = [" + e + "]");
              }

              @Override
              public void onComplete() {
                  Log.e(TAG, "onComplete() called");
              }
          });
    }


    Observable observable;
    public void login(String email, String pass){
        RequestLogin requestLogin = new RequestLogin(email,pass);

        observable =
        getClient()
          .getApi()
          .postRequest(BuildConfig.endpoint+"/api/rest/model/atg/userprofiling/ProfileActor/login",requestLogin.toMap())
          .subscribeOn(Schedulers.io())
          .observeOn(Schedulers.io())
          .toObservable();

        observable
          .map(new Function() {
              @Override
              public Object apply(Object o) throws Exception {
                  Log.d(TAG, "apply() called with: o = [" + o + "]");
                  return o;
              }
          })
          .subscribeWith(new DisposableObserver() {
              @Override
              public void onNext(Object value) {
                  //operations in background thread
                  Log.e(TAG, "onNext() called with: value = [" + value + "]");
                  Log.e(TAG, "onNext: USER LOGGED" );
                  initiateCO();
              }

              @Override
              public void onError(Throwable e) {
                  // if something going wrong
                  Log.e(TAG, "onError() called with: e = [" + e + "]");
              }

              @Override
              public void onComplete() {
                  Log.e(TAG, "onComplete() called");
                  initiateCO();

              }
          });

    }


    private void initiateCO(){
        getClient()
          .getApi()
          .postRequest
            (
              BuildConfig.endpoint+"/api/rest/model/atg/commerce/order/purchase/ShippingGroupActor/initiateCheckout",
              new HashMap<String, String>()
            )
          .subscribeOn(Schedulers.io())
          .observeOn(Schedulers.io())
          .toObservable()
          .map(new Function() {
              @Override
              public Object apply(Object o) throws Exception {
                  return o;
              }
          })
          .subscribeWith(new DisposableObserver() {
              @Override
              public void onNext(Object value) {
                  //operations in background thread
                  Log.d(TAG, "onNext() called with: value = [" + value + "]");
              }

              @Override
              public void onError(Throwable e) {
                  // if something going wrong
              }

              @Override
              public void onComplete() {

              }
          });
    }


    @Override
    public DemoClient getClient() {
        return super.getClient();
    }
}
