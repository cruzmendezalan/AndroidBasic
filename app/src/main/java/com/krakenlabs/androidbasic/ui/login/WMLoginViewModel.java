package com.krakenlabs.androidbasic.ui.login;

import android.text.Editable;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

public class WMLoginViewModel extends ViewModel {
   private LoginModel loginModel;
   private static final String TAG = "WMLoginViewModel";

   public WMLoginViewModel() {
      loginModel = new LoginModel();
   }

   /**
    * @param editable         editable
    * @param loginModel the model of user profile
    */
   public void emailTextChanged(@NonNull Editable editable,
                                  @NonNull LoginModel loginModel) {
      loginModel.setEmail(editable.toString());
      this.loginModel = loginModel;
   }

   public void passwordTextChanged(@NonNull Editable editable,
                                @NonNull LoginModel loginModel) {
      loginModel.setPassword(editable.toString());
      this.loginModel = loginModel;
   }


   public LoginModel getLoginModel() {
      return loginModel;
   }

}
