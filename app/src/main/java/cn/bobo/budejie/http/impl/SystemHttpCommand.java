package cn.bobo.budejie.http.impl;

import android.util.Log;

import java.util.HashMap;

import cn.bobo.budejie.http.IHttpCommand;
import cn.bobo.budejie.http.IRequestParam;
import cn.bobo.budejie.http.utils.HttpUtils;

/**
 * Created by Leon on 2018/9/22.
 * Functions:
 */
public class SystemHttpCommand implements IHttpCommand<HashMap<String,Object>>{

    @Override
    public String execute(String url, IRequestParam<HashMap<String, Object>> requestParam) {
        try{
            return HttpUtils.post(url,requestParam.getRequestParam());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
