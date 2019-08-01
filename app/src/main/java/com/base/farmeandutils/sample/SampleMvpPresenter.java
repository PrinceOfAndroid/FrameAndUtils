package com.base.farmeandutils.sample;

import com.base.baselib.base.mvp.MvpBasePresenter;

public class SampleMvpPresenter extends MvpBasePresenter<ISampleContract.ISampleView> implements ISampleContract.ISamplePresenter {

    @Override
    public void initData() {

    }

    @Override
    public void login(String account, String pwd) {
        mView.setText("登录成功");
    }
}
