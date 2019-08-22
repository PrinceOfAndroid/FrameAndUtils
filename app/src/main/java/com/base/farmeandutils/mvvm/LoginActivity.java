package com.base.farmeandutils.mvvm;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.base.farmeandutils.R;
import com.base.farmeandutils.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity{

    private ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //databinding初始化
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        //生成ViewModel实例 与业务相关操作放ViewModel  ViewModel不持有view的引用 解耦合 通过LiveData通知view操作
        final LoginViewModel loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginBinding.setViewModel(loginViewModel);
        loginBinding.setLifecycleOwner(this);

        loginBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.login();
            }
        });

        //观察者模式监控登录状态  绑定Activity生命周期防止内存泄漏
        loginViewModel.getLoginStatus().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer==null){
                    return;
                }
                switch (integer){
                    case LoginStatus.LOGIN:
                        loginBinding.btnLogin.setText("登录中...");
                        break;
                    case LoginStatus.LOGING_FAIL:
                        loginBinding.btnLogin.setText("登录成功！");
                        break;
                    case LoginStatus.LOGING_SUCCESS:
                        loginBinding.btnLogin.setText("登录失败！");
                        break;
                }
            }
        });
    }
}

