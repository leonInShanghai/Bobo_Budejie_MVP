package cn.bobo.budejie.pro.attention.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.List;

import cn.bobo.budejie.bean.AttentionSubscriptionBean;
import cn.bobo.budejie.http.utils.HttpUtils;
import cn.bobo.budejie.pro.attention.model.AttentionSubscriptionModel;
import cn.bobo.budejie.pro.base.model.BaseModel;
import cn.bobo.budejie.pro.base.presenter.BasePresener;
import cn.bobo.budejie.utils.GsonUtils;

/**
 * Created by Leon on 2018/10/2
 * Functions:
 */
public class AttentionSubscriptionPresenter extends BasePresener<AttentionSubscriptionModel>{


    public AttentionSubscriptionPresenter(Context context){
        super(context);
    }


    @Override
    public AttentionSubscriptionModel bingModel() {
        return new AttentionSubscriptionModel(getContext());
    }

    public void getAttentionSubscriptionList(int type,final OnUIThreadListener<List<AttentionSubscriptionBean>>
            onUIThreadListener){
        getModel().getAttentionSubscriptionList(type, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                if (TextUtils.isEmpty(result)){
                    onUIThreadListener.onResult(null);
                }else {
                    List<AttentionSubscriptionBean> list = GsonUtils.getList(result,AttentionSubscriptionBean.class);
                    onUIThreadListener.onResult(list);
                }
            }
        });

    }
}
