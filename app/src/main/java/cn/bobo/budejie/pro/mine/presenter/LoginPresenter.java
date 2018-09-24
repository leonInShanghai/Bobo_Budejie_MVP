package cn.bobo.budejie.pro.mine.presenter;

import android.content.Context;
import android.text.TextUtils;

import cn.bobo.budejie.bean.UserBean;
import cn.bobo.budejie.http.utils.HttpUtils;
import cn.bobo.budejie.pro.base.presenter.BasePresener;
import cn.bobo.budejie.pro.mine.model.LoginMidel;
import cn.bobo.budejie.utils.ToastUtil;

/**
 * Created by Leon on 2018/9/24.
 * Functions:
 */
public class LoginPresenter extends BasePresener<LoginMidel>{

    public LoginPresenter(Context context) {
        super(context);
    }

    @Override
    public LoginMidel bingModel() {
        return new LoginMidel(getContext());
    }

    public void login(String username, String password, final OnUIThreadListener<UserBean> onUIThreadListener){
       if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
           ToastUtil.showToast(getContext(),"账号或密码不能为空");
       }else {
           getModel().login(username, password, new HttpUtils.OnHttpResultListener() {
               @Override
               public void onResult(String result) {
                   //解析model
                   if (result == null){
                       onUIThreadListener.onResult(null);
                   }else {
                       UserBean userBean = getGson().fromJson(result,UserBean.class);
                       onUIThreadListener.onResult(userBean);
                   }
               }
           });
       }
    }
}
