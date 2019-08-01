package com.base.farmeandutils.sample.mutil;

import com.base.baselib.base.mvp.IBasePresenter;
import com.base.baselib.base.mvp.IBaseView;

public interface ISample2Contract {

    interface ISampleView extends IBaseView {

        void setRegisterText(String text);

    }


    interface ISamplePresenter extends IBasePresenter<ISampleView> {

        void register(String account, String pwd);

    }


}
