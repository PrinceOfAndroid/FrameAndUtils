package com.base.farmeandutils.mvvm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class LoginModel implements ILoginModel {

    public static final int LOGIN_SUCCESS_CODE = 1;
    private LoginCallback callback;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == LOGIN_SUCCESS_CODE) {
                if (callback != null) {
                    callback.callBack((User) msg.obj);
                }
            }
        }
    };

    @Override
    public void login(final User user, LoginCallback callback) {
        this.callback = callback;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = Message.obtain();
                message.what = LOGIN_SUCCESS_CODE;
                message.obj = user;
                mHandler.sendMessage(message);
            }
        }).start();
    }



    public interface LoginCallback {
        void callBack(User user);
    }


}
