package cn.bobo.budejie.pro.essence.model;

import android.content.Context;
import android.text.TextUtils;

import cn.bobo.budejie.http.impl.RequestParam;
import cn.bobo.budejie.http.impl.SystemHttpCommand;
import cn.bobo.budejie.http.utils.HttpTask;
import cn.bobo.budejie.http.utils.HttpUtils;
import cn.bobo.budejie.pro.base.model.BaseModel;

/**
 * Created by Leon on 2018/9/22.
 * Functions: 请求网络数据或者加载本地数据库缓存数据或者加载SD卡数据等等
 * M层:数据层
 * API接口\百思不得姐-精华全部
 */
public class EssenceVideoModel extends BaseModel {


    public EssenceVideoModel(Context context) {
        super(context);

    }

    private String getUrl(){
        //拼接请求接口 上次少了一个 / 找bug找半天
        return getServerUrl().concat("/api/api_open.php");
    }

    /**
     * 定义访问精华接口
     * 第一步：定义URL
     * 第二部：定义接口
     */
    public void getEssenceList(int type, int page, String maxtime,
                               HttpUtils.OnHttpResultListener onHttpResultListener){
        RequestParam requestParam = new RequestParam();
        //a  true  string  参数值为list，如果想要获取“新帖”板块的帖子，则传入"newlist"即可
        requestParam.put("a","list");
        //c  true  string  data
        requestParam.put("c","data");
        //type  false  int  1为全部，10为图片，29为段子，31为音频，41为视频，默认为1
        requestParam.put("type",type);
        //page  false  int  当前所加载的页码数，默认为0
        requestParam.put("page",page);
        //   true  string  第一次加载帖子时候不需要传入此关键字，
        // 当需要加载下一页时：需要传入加载上一页时返回值字段“maxtime”中的内容。
        if (!TextUtils.isEmpty(maxtime)){
            requestParam.put("maxtime",maxtime);
        }

        //发送网络请求
        HttpTask httpTask = new HttpTask(getUrl(),requestParam,new SystemHttpCommand(),
                onHttpResultListener);

        //开始执行网络请求
        httpTask.execute();
    }

}
