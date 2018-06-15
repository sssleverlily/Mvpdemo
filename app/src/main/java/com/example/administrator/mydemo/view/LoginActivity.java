package com.example.administrator.mydemo.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.presenter.ILoginPresenter;
import com.example.administrator.mydemo.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements IloginView, View.OnClickListener  {
    EditText name;
    EditText psw;
    Button logIn;
    Button clear;
    ILoginPresenter loginPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        logIn = findViewById(R.id.bt_login);
        name = findViewById(R.id.account);
        psw = findViewById(R.id.password);
        clear = findViewById(R.id.clear);
        logIn.setOnClickListener(this);
        loginPresenter = new LoginPresenter(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clear:
                loginPresenter.clear();
                break;
            case R.id.bt_login:
                logIn.setEnabled(false);
                clear.setEnabled(false);
                loginPresenter.doLogin(name.getText().toString(), psw.getText().toString());
                break;
        }
    }

    @Override
    public void onClearText() {
        name.setText("");
        psw.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        logIn.setEnabled(true);
        clear.setEnabled(true);
        if (result){
            Toast.makeText(this,"登录成功O(∩_∩)O~",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this,"好像有点问题",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
