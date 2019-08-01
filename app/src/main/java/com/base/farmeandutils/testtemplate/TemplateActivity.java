package com.base.farmeandutils.testtemplate;

import android.os.Bundle;

import com.base.baselib.base.mvp.MvpBaseActivity;
import com.base.farmeandutils.R;

public class TemplateActivity extends MvpBaseActivity<TemplatePresenter> implements ITemplateContract.ITemplateView {
    @Override
    protected TemplatePresenter buildPresenter() {
        return new TemplatePresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_template;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initEventLoadData() {

    }


}

