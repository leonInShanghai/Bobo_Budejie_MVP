package cn.bobo.budejie.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.bobo.budejie.mvp.presenter.impl.MvpBaseaPresenter;
import cn.bobo.budejie.mvp.view.MvpView;

/**
 * Created by Leon on 2018/9/3.
 * MvpActivity -- 是MVP框架的activity
 * Functions: 将我们的MVP架构集成到我们的activity
 */
public abstract class MvpActivity<P extends MvpBaseaPresenter> extends AppCompatActivity implements MvpView{

    /**MVP架构P是动态的*/
    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = bindPresenter();

        //presenter关联view
        if (presenter != null){
            presenter.attachView(this);
        }
    }

    /**具体的实现我不知道我交给别人实现*/
    public abstract P bindPresenter();

    @Override
    protected void onDestroy() {

        //activity销毁的时候--解除绑定
        if (presenter != null){
            presenter.detachView();
        }

        super.onDestroy();
    }
}
