package cn.bobo.budejie.pro.base.presenter;

import android.content.Context;

import com.google.gson.Gson;

import cn.bobo.budejie.mvp.presenter.impl.MvpBaseaPresenter;
import cn.bobo.budejie.pro.base.model.BaseModel;

/**
 * Created by Leon on 2018/9/22.
 * Functions:
 */
public abstract class BasePresener<M extends BaseModel> extends MvpBaseaPresenter{

    private Context context;
    private Gson gson;
    private M model;

    public BasePresener (Context context){
        this.context = context;
        this.gson = new Gson();
        this.model = bingModel();
    }

    public Context getContext() {
        return context;
    }

    public Gson getGson() {
        return gson;
    }

    public M getModel() {
        return model;
    }

    public abstract M bingModel();

    public interface OnUIThreadListener<T>{
       public void onResult(T result);
    }
}
