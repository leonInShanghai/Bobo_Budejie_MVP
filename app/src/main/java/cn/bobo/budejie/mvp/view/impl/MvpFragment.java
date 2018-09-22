package cn.bobo.budejie.mvp.view.impl;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;

import cn.bobo.budejie.mvp.presenter.impl.MvpBaseaPresenter;
import cn.bobo.budejie.mvp.view.MvpView;

/**
 * Created by Leon on 2018/9/8.
 * MvpFragment--MVP框架的Fragment
 * Functions: Fragment的优势是布局在不同设备上的适配
 */
public abstract class MvpFragment<P extends MvpBaseaPresenter> extends Fragment implements MvpView{

    protected P presenter;

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //绑定视图
        presenter = bindPresenter();

        if (presenter != null){
            presenter.attachView(this);
        }
    }

    /**绑定Presenter*/
    public abstract P bindPresenter();


    @Override
    public void onDestroyView() {

        //解除绑定
        if (presenter != null){
            presenter.detachView();
        }

        super.onDestroyView();
    }

}
