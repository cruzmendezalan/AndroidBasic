package com.krakenlabs.androidbasic.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputLayout;
import com.krakenlabs.androidbasic.R;
import com.krakenlabs.androidbasic.databinding.WmloginFragmentBinding;
import com.krakenlabs.androidbasic.ui.basic.BaseFragment;


public class WMLoginFragment extends BaseFragment {
    public static final String                 TAG = "WMLoginFragment";
    private             WMLoginViewModel       mViewModel;
    private             WmloginFragmentBinding uiBinding;//connection between UI&model

    public static WMLoginFragment newInstance() {
        return new WMLoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(WMLoginViewModel.class);
//        mViewModel.getLoginModel().setEmail(getsharedPreferencesValue(WMLoginFragment.TAG));/*si hay un email previamente guardado, lo insertamos en el formulario*/
//        mViewModel.getLoginModel().setPassword
//          (
//            getWMActivity()
//            .getAccountManager()
//            .getPassword
//              (
//                mViewModel.getLoginModel().getEmail()
//              )
//          );
        uiBinding = DataBindingUtil.inflate(inflater, R.layout.wmlogin_fragment, container, false);
        uiBinding.setViewmodel(mViewModel);
        uiBinding.setModel(mViewModel.getLoginModel());
        uiBinding.setFragment(this);
        return uiBinding.getRoot();
    }

    public void click(@NonNull View v) {
        if (v.getId() == R.id.btn_login){
            uiBinding.tieEmail.setText(uiBinding.tieEmail.getText());
            uiBinding.tiePassword.setText(uiBinding.tiePassword.getText());


            TextInputLayout[] validations = new TextInputLayout[]{
              uiBinding.tilEmail,
              uiBinding.tilPassword,
            };

            boolean isValid = true;
            for (TextInputLayout view : validations) {

                if (view.isErrorEnabled()) {
                    isValid = false;
                }
            }
            // TODO: 2019-05-29 submit the request
//            if (isValid){//submit the request
//                mViewModel
//                  .getLoginModel()
//                  .setBusy(true);
//
//                try{
//                    getAuthController()
//                      .login(mViewModel.getLoginModel(),this);
//                 }catch (Exception e){
//                   manageException(e);
//                }
//            }

        }else if (v.getId() == R.id.btn_register){
//            getWMActivity()
//              .addFragment
//                (
//                  getWMActivity()
//                  .getFragmentsFactory()
//                  .getRegisterFragment(null)
//                );
        }
    }

// TODO: 2019-05-29 callback de comunicacion con api
//    @Override
//    public void authControllerEvent(AuthControllerEventType eventType, AuthControllerObject authControllerObject) {
//        super.authControllerEvent(eventType, authControllerObject);
//        switch (eventType){
//            case LOGIN:{
//                if (authControllerObject.getCode() == 0){
//                    saveInSharedPreferences(WMLoginFragment.TAG,mViewModel.getLoginModel().email);
//
//                    getWMActivity()
//                      .getAccountManager()
//                      .saveLogin
//                        (
//                          mViewModel.getLoginModel().getEmail(),
//                          mViewModel.getLoginModel().getPassword()
//                        );
//
//                    getWMActivity()
//                      .popBackAll();
//
//                }else{
//                    mViewModel
//                      .getLoginModel()
//                      .setBusy(false);
//                }
//            }
//        }
//    }
}
