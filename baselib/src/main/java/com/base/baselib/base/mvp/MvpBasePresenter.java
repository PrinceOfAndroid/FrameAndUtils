package com.base.baselib.base.mvp;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by PrinceOfAndroid on 2018/4/9 0009.
 * presenter 基类(持有view)
 */

public abstract class MvpBasePresenter<T extends IBaseView> implements IBasePresenter<T>{
    protected T mView;
    private CompositeDisposable mCompositeDisposable;

    /**
     * 绑定 view
     *
     * @param view
     */
    public void attachView(T view) {
        //弱引用避免内存泄漏
        this.mView = new WeakReference<>(view).get();
    }

    /**
     * view 解绑
     */
    public void detachView() {
        unSubscribe();
        if (mView != null) {
            mView = null;
        }
        onDestroy();
    }

    protected void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    protected void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }


    /**
     * 初始化加载
     */
    public abstract void initData();

    /**
     * 释放资源
     */
    public void onDestroy() {

    }

}
