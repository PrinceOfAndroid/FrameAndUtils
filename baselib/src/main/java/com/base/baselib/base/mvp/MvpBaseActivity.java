package com.base.baselib.base.mvp;

import android.app.ProgressDialog;
import android.content.Context;

import com.base.baselib.base.SimpleActivity;


/**
 * <pre>
 *     author   : PrinceOfAndroid
 *     created  : 2017/7/5 0005 11:56
 *     desc     : activity mvp基础类
 * </pre>
 */
public abstract class MvpBaseActivity<T extends MvpBasePresenter> extends SimpleActivity
        implements IBaseView {
    protected T mPresenter;
    protected ProgressDialog progressDialog;

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        //初始化 presenter 执行onCreate() 生命周期 绑定view(activity)
        mPresenter = buildPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
            mPresenter.initData();
        }
    }

    /**
     * 抽象生成presenter 交给子类去实现
     *
     * @return
     */
    protected abstract T buildPresenter();


    @Override
    public void showLoading(String msg) {
        if (progressDialog == null) {
//            progressDialog = ProgressDialogManager.getProgressDialog(this);
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    @Override
    public void dismissLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showMsg(String msg) {
//        ToastUtils.showShort(msg);
    }

    @Override
    public Context getContext() {
        return this;
    }

    /**
     * onDestroy 事件 释放资源
     */
    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

}
