package com.base.farmeandutils.testtemplate;

import com.base.baselib.base.mvp.IBasePresenter;
import com.base.baselib.base.mvp.IBaseView;


public interface ITemplateContract {

    interface ITemplateView extends IBaseView {


    }


    interface ITemplatePresenter extends IBasePresenter<ITemplateView> {


    }


}
