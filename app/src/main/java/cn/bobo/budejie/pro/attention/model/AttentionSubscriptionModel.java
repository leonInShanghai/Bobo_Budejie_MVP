package cn.bobo.budejie.pro.attention.model;

import android.content.Context;

import cn.bobo.budejie.http.impl.RequestParam;
import cn.bobo.budejie.http.impl.SystemHttpCommand;
import cn.bobo.budejie.http.utils.HttpTask;
import cn.bobo.budejie.http.utils.HttpUtils;
import cn.bobo.budejie.pro.base.model.BaseModel;

/**
 * Created by Leon on 2018/10/2
 * Functions:
 */
public class AttentionSubscriptionModel extends BaseModel {

    private static final String URL_STR = "/api/api_open.php";


    public AttentionSubscriptionModel(Context context) {
        super(context);
    }

    public void getAttentionSubscriptionList(int type, HttpUtils.OnHttpResultListener onHttpResultListener){
        RequestParam requestParam = new RequestParam();
        //a	true	string	tag_recommend
        requestParam.put("a","tag_recommend");
        //action	true	string	sub
        requestParam.put("action","sub");
        //c	true	string	topic
        requestParam.put("c","topic");
        //type	false	int	要求“推荐标签”中包含以下类型 1为全部，10为图片，29为段子，31为音频，41为视频
        //默认为0
        requestParam.put("type",type);
        //limit	false	int	最多显示50个推荐标签
        //requestParam.put("limit",20);
        //device	false	string	ios设备
        requestParam.put("device","Android设备");

        HttpTask httpTask = new HttpTask(getServerUrl().concat(URL_STR),requestParam,new SystemHttpCommand(),onHttpResultListener);
        httpTask.execute();
    }
}
