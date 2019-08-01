package com.base.baselib.base.mvp;

import android.content.Context;

/**
 * Created by PrinceOfAndroid on 2018/4/9 0009.
 */

public interface IBaseView {


    void showLoading(String msg);

    void showMsg(String msg);

    void dismissLoading();

    /**
     * 获取上下文
     * @return
     */
    Context getContext();
}
