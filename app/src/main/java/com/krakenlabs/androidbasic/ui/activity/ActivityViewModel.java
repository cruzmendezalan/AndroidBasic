package com.krakenlabs.androidbasic.ui.activity;

import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.krakenlabs.androidbasic.MainActivity;
import com.krakenlabs.androidbasic.R;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Alan Giovani Cruz Méndez on 2019-05-29 11:42.
 * cruzmendezalan@gmail.com
 */
public class ActivityViewModel extends ViewModel {
    private MainActivity    activity;
    private ActivityModel   activityModel;

    public ActivityViewModel() {
    }

    public MainActivity getActivity() {
        return activity;
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    public ActivityModel getActivityModel() {
        return activityModel;
    }

    public void setActivityModel(ActivityModel activityModel) {
        this.activityModel = activityModel;
    }

    public Drawable getLoginButtonStyle(){
//        if (superamaActivity.getAuthController().isSessionActive()){
//            return superamaActivity.getDrawable(R.drawable.wm_btn_gray);
//        }

        return activity.getDrawable(R.drawable.wm_btn_blue);
    }

    private void initSessionObserver(){
//        getSuperamaActivity()
//          .getAuthController()
//          .getWmObservables()
//          .getSessionPublisher()
//          .subscribe(new Observer<Boolean>() {
//              @Override
//              public void onSubscribe(Disposable d) {
//
//              }
//
//              @Override
//              public void onNext(Boolean aBoolean) {
//                  Log.d(TAG, "onNext() called with: aBoolean = [" + aBoolean + "]");
//                  getWMActivityModel()
//                    .setSessionActive(aBoolean);
//                  if (aBoolean == true){
//                      getWMActivityModel()
//                        .setLabelHeader
//                          (
//                            getSuperamaActivity().getsharedPreferencesValue(WMLoginFragment.TAG)
//                          );
//                      getWMActivityModel()
//                        .setLabelButtonLogin(superamaActivity.getResources().getString(R.string.btn_cerrar_sesion));
//                  }else{
//                      getWMActivityModel()
//                        .setLabelHeader
//                          (
//                            getSuperamaActivity()
//                              .getResources()
//                              .getString(R.string.hello_blank_fragment)
//                          );
//
//                      getWMActivityModel()
//                        .setLabelButtonLogin(superamaActivity.getResources().getString(R.string.btn_iniciar_sesion));
//                      getSuperamaActivity()
//                        .getAccountManager()
//                        .removeAccount
//                          (
//                            getSuperamaActivity()
//                              .getsharedPreferencesValue(WMLoginFragment.TAG)
//                          );
//                  }
//
//              }
//
//              @Override
//              public void onError(Throwable e) {
//
//              }
//
//              @Override
//              public void onComplete() {
//
//              }
//          });
    }



    private static final String TAG = "ActivityViewModel";

    public void loginOrLogout(){
        Log.d(TAG, "loginOrLogout() called");
        activity.addFragment
          (
            activity
            .getFragmentFactory()
            .getLoginFrsgment(null)
          );
//        try{
//            if (!superamaActivity.getAuthController().isSessionActive()){
//                getSuperamaActivity()
//                  .addFragment
//                    (
//                      getSuperamaActivity()
//                        .getFragmentsFactory()
//                        .getLoginFragment(null)
//                    );
//            }else{
//                getSuperamaActivity()
//                  .getAuthController()
//                  .logout(null,null);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

}
