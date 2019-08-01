package com.base.baselib.base.mvp;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.Nullable;

import com.base.baselib.base.SimpleFragment;
/**
 * Created by PrinceOfAndroid on 2018/4/25 0025.
 */

public abstract class MvpBaseFragment<T extends MvpBasePresenter> extends SimpleFragment
        implements IBaseView {
    protected T mPresenter;
    protected ProgressDialog progressDialog;

    /**
     * 初始化已完成
     */
    @Override
    protected void onCreateFinish() {
        super.onCreateFinish();
        mPresenter = buildPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
            mPresenter.initData();
        }
    }

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void showLoading(String msg) {
        if (progressDialog == null) {
//            progressDialog = ProgressDialogManager.getProgressDialog(getContext());
            progressDialog.setMessage(msg);
        }
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
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDetach();
    }

    public abstract T buildPresenter();


}
