package com.base.farmeandutils.sample.mutil;

import com.base.baselib.base.mvp.MvpBasePresenter;
import com.base.farmeandutils.sample.ISampleContract;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class Sample2MvpPresenter extends MvpBasePresenter<ISample2Contract.ISampleView> implements ISample2Contract.ISamplePresenter {

    @Override
    public void initData() {

        Disposable subscribe = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {

            }
        }).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {

            }
        });
    }

    @Override
    public void register(String account, String pwd) {
        mView.setRegisterText("注册成功");
    }
}
