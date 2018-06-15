package com.example.administrator.mydemo.presenter;


import android.os.Handler;
import android.os.Looper;
import com.example.administrator.mydemo.model.Iuser;
import com.example.administrator.mydemo.model.UserModel;
import com.example.administrator.mydemo.view.IloginView;
import com.example.administrator.mydemo.view.LoginActivity;

public class LoginPresenter implements ILoginPresenter {
    IloginView iLoginView;
    Iuser user;
    Handler    handler;

    public LoginPresenter(IloginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name,passwd);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 5000);

    }




    private void initUser(){
        user = new UserModel("mvp","mvp");
    }
}

