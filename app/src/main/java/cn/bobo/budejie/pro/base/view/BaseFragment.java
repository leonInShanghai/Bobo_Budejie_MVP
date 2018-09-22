package cn.bobo.budejie.pro.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.bobo.budejie.mvp.presenter.impl.MvpBaseaPresenter;
import cn.bobo.budejie.mvp.view.impl.MvpFragment;

/**
 * Created by Leon on 2018/9/8.
 * Functions: 项目自己的 Fragment 需要缓存视图
 */
public abstract class BaseFragment<P extends MvpBaseaPresenter> extends MvpFragment<P>{

    private View viewContent;//缓存视图View


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //缓存视图
        if (viewContent == null){
            viewContent = inflater.inflate(getContentView(),container,false);
            initContentView(viewContent);
            initData();
        }

        //判断Fragment 对应的 Activity 是否存在这个视图
        ViewGroup parent = (ViewGroup)viewContent.getParent();

        if (parent != null){
            //如果存在移除重新添加，这样的方式我们就可以缓存视图
            parent.removeView(viewContent);
        }
        return viewContent;
    }

    @Override
    public P bindPresenter() {
        return null;
    }

    public abstract int getContentView();

    public void initData(){

    }

    public abstract void initContentView(View viewContent);

}












