package cn.bobo.budejie.mvp.presenter.impl;

import cn.bobo.budejie.mvp.presenter.MvpPresenter;
import cn.bobo.budejie.mvp.view.MvpView;

/**
 * Created by Leon on 2018/9/3.
 * Functions:
 */
public abstract class MvpBaseaPresenter<V extends MvpView> implements MvpPresenter<V>{

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null){
            view = null;
        }
    }
}
