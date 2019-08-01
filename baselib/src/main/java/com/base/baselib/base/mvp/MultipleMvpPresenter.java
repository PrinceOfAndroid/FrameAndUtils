package com.base.baselib.base.mvp;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Presenter 复用基类  T(继承MvpBaseView的View)   Q(继承MvpBasePresenter的presenter)
 *
 * @param <T>
 */
public class MultipleMvpPresenter<T extends IBaseView> extends MvpBasePresenter<T> {
    protected T mView;
    private List<MvpBasePresenter> presenters = new ArrayList<>();

    @SafeVarargs
    public final <Q extends MvpBasePresenter<T>> void requestPresenter(Q... cls) {
        for (Q cl : cls) {
            presenters.add(cl);
        }
    }

    @Override
    public void attachView(T view) {
        for (MvpBasePresenter presenter : presenters) {
            presenter.attachView(view);
        }
        //弱引用避免内存泄漏
        this.mView = new WeakReference<>(view).get();
    }

    public MultipleMvpPresenter(T mView) {
        this.mView = mView;
    }

    @Override
    public void detachView() {
        for (MvpBasePresenter presenter : presenters) {
            presenter.detachView();
        }
        if (mView != null) {
            mView = null;
        }
        onDestroy();
    }

    @Override
    public void initData() {
        for (MvpBasePresenter presenter : presenters) {
            presenter.initData();
        }
    }

}
