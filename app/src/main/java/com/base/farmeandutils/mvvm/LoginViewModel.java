package com.base.farmeandutils.mvvm;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

public class LoginViewModel extends AndroidViewModel {
    private ILoginModel loginModel;
    private MutableLiveData<Integer> loginStatus = new MutableLiveData<>();

    //name pwd 与EditText绑定
    private ObservableField<String> name = new ObservableField<>();
    private ObservableField<String> pwd = new ObservableField<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginModel = new LoginModel();
    }

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableField<String> getPwd() {
        return pwd;
    }

    public MutableLiveData<Integer> getLoginStatus() {
        return loginStatus;
    }


    public void login() {
        String nameStr = name.get();
        String pwdStr = pwd.get();

        User user = new User();
        user.setName(nameStr);
        user.setPwd(pwdStr);

        loginStatus.setValue(LoginStatus.LOGIN);
        //model层做数据相关操作，用回调进行通知。
        loginModel.login(user, new LoginModel.LoginCallback() {
            @Override
            public void callBack(User user) {
                if (user.getCode() == LoginModel.LOGIN_SUCCESS_CODE) {
                    loginStatus.setValue(LoginStatus.LOGIN_SUCCESS);
                } else {
                    loginStatus.setValue(LoginStatus.LOGIN_FAIL);
                }
            }
        });
    }


}
