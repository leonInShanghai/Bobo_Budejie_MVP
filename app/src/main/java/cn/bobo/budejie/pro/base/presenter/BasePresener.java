package cn.bobo.budejie.pro.base.presenter;

import android.content.Context;

import com.google.gson.Gson;

import cn.bobo.budejie.mvp.presenter.impl.MvpBaseaPresenter;

/**
 * Created by Leon on 2018/9/22.
 * Functions:
 */
public abstract class BasePresener extends MvpBaseaPresenter{

    private Context context;
    private Gson gson;

    public BasePresener (Context context){
        this.context = context;
        this.gson = new Gson();
    }

    public Context getContext() {
        return context;
    }

    public Gson getGson() {
        return gson;
    }

    public interface OnUIThreadListener<T>{
       public void onResult(T result);
    }
}
