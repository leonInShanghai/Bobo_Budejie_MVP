package cn.bobo.budejie.mvp.view.impl;

/**
 * Created by Leon on 2018/9/3.
 * Functions:
 */
public abstract class MvpBaseLceView<M> implements MvpLceView<M> {

    @Override
    public void showLoading(boolean pullToRefresh) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Exception e, boolean pullToRefresh) {

    }

    @Override
    public void showData(M data) {

    }
}

