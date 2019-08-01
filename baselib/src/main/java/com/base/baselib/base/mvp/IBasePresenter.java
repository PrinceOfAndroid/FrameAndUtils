package com.base.baselib.base.mvp;

public interface IBasePresenter<T extends IBaseView> {
     void attachView(T view);

     void detachView();

     void onDestroy();
}
