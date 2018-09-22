package cn.bobo.budejie.pro.base.model;

import android.content.Context;

import cn.bobo.budejie.mvp.model.MvpModel;

/**
 * Created by Leon on 2018/9/22.
 * Functions:
 */
public abstract class BaseModel implements MvpModel{

    private Context context;

    public BaseModel(Context context){
        this.context = context;
    }

    public String getServerUrl(){
        //http://api.budejie.com/api/api_open.php
        return "http://api.budejie.com";
    }
}
