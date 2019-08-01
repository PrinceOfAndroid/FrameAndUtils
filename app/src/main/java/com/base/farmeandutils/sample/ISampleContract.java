package com.base.farmeandutils.sample;

import com.base.baselib.base.mvp.IBasePresenter;
import com.base.baselib.base.mvp.IBaseView;

public interface ISampleContract {

    interface ISampleView extends IBaseView {

        void setText(String text);

    }


    interface ISamplePresenter extends IBasePresenter<ISampleView> {

        void login(String account, String pwd);

    }


}
