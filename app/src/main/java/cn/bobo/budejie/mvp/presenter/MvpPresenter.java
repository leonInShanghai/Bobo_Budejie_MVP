package cn.bobo.budejie.mvp.presenter;

import cn.bobo.budejie.mvp.view.MvpView;

/**
 * Created by Leon on 2018/9/3.
 * Functions: 中介
 */
public interface MvpPresenter<V extends MvpView> {

    /**绑定view*/
    public void attachView(V view);

    /**解除绑定view*/
    public void detachView();
}
