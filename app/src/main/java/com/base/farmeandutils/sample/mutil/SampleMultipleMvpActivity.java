package com.base.farmeandutils.sample.mutil;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.base.baselib.base.mvp.MultipleMvpPresenter;
import com.base.baselib.base.mvp.MvpBaseActivity;
import com.base.farmeandutils.R;
import com.base.farmeandutils.sample.ISampleContract;
import com.base.farmeandutils.sample.SampleMvpPresenter;

/**
 * 多个presenter 合并使用
 */
public class SampleMultipleMvpActivity extends MvpBaseActivity<MultipleMvpPresenter> implements ISampleContract.ISampleView
, ISample2Contract.ISampleView {
    private TextView sampleText;
    private TextView sampleText2;
    private Sample2MvpPresenter sample2MvpPresenter;
    private SampleMvpPresenter sampleMvpPresenter;

    @Override
    protected MultipleMvpPresenter buildPresenter() {
        MultipleMvpPresenter multipleMvpPresenter =new MultipleMvpPresenter<>(this);
        sampleMvpPresenter = new SampleMvpPresenter();
        sample2MvpPresenter = new Sample2MvpPresenter();
        multipleMvpPresenter.requestPresenter(sampleMvpPresenter);
        multipleMvpPresenter.requestPresenter(sample2MvpPresenter);
        return multipleMvpPresenter;
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
                sampleMvpPresenter.login("11", "22");
            }
        });

        sampleText2 = findViewById(R.id.sample_text2);
        sampleText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sample2MvpPresenter.register("11", "22");
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

    @Override
    public void setRegisterText(String text) {
        sampleText2.setText(text);
    }
}
