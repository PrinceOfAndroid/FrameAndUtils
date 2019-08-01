package com.base.farmeandutils.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.base.baselib.base.mvp.MvpBaseActivity;
import com.base.farmeandutils.R;
import com.base.farmeandutils.sample.ISampleContract;
import com.base.farmeandutils.sample.SampleMvpPresenter;

public class SampleMvpActivity extends MvpBaseActivity<SampleMvpPresenter> implements ISampleContract.ISampleView {
    private TextView sampleText;

    @Override
    protected SampleMvpPresenter buildPresenter() {
        return new SampleMvpPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        sampleText = findViewById(R.id.sample_text);
        sampleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login("11", "22");
            }
        });
    }

    @Override
    protected void initEventLoadData() {

    }

    @Override
    public void setText(String text) {
        sampleText.setText(text);
    }
}
