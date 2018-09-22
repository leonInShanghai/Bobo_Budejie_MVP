package cn.bobo.budejie.mvp.view.impl;

import cn.bobo.budejie.mvp.view.MvpView;

/**
 * Created by Leon on 2018/9/3.
 * Functions:请求数据，刷新UI界面监听(标准)-就是经常看到的loading页
 */
public interface MvpLceView<M> extends MvpView{

    /**显示加载中的视图-监听加载的类型：下拉刷新或者上拉加载*/
    public void showLoading(boolean pullToRefresh);

    /**显示ContentView显示内容*/
    public void showContent();

    /**加载错误*/
    public void showError(Exception e,boolean pullToRefresh);

    /**绑定数据*/
    public void showData(M data);
}
