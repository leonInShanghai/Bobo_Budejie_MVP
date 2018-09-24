package cn.bobo.budejie.pro.mine.model;

import android.content.Context;


import cn.bobo.budejie.http.impl.RequestParam;
import cn.bobo.budejie.http.impl.SystemHttpCommand;
import cn.bobo.budejie.http.utils.HttpTask;
import cn.bobo.budejie.http.utils.HttpUtils;
import cn.bobo.budejie.pro.base.model.BaseModel;

/**
 * Created by Leon on 2018/9/24.
 * Functions:
 */
public class LoginMidel extends BaseModel{

    public LoginMidel(Context context) {
        super(context);
    }

    public void login(String username, String password, HttpUtils.OnHttpResultListener onHttpResultListener){
        RequestParam requestParam = new RequestParam();
        //requestParam.put("username",username);
        requestParam.put("mobile",username);
        requestParam.put("password",password);
        //http://192.168.57.1:8080/Dream/LoginServlet"
        HttpTask httpTask = new HttpTask("http://wechat.lingyongdai.cn/passport/login",
                requestParam,new SystemHttpCommand(),onHttpResultListener);
        httpTask.execute();
    }

}
