package cn.bobo.budejie.pro.essence.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

import cn.bobo.budejie.bean.PostsListBean;
import cn.bobo.budejie.http.utils.HttpUtils;
import cn.bobo.budejie.pro.base.model.BaseModel;
import cn.bobo.budejie.pro.base.presenter.BasePresener;
import cn.bobo.budejie.pro.essence.model.EssenceVideoModel;

/**
 * Created by Leon on 2018/9/22.
 * Functions: .MVP 中的 P 层 ：处理数据返回之后的逻辑
 * 例如：数据解析 等等业务逻辑
 */
public class EssenceVideoPresenter extends BasePresener<EssenceVideoModel> {

    private int page = 0;

    /**下拉刷新需要的参数*/
    private String maxtime = null;

    public EssenceVideoPresenter(Context context) {
        super(context);
    }

    @Override
    public EssenceVideoModel bingModel() {
        return new EssenceVideoModel(getContext());
    }

    //定义解析的函数
    public void getEssenceList(int type, final boolean isDownRefresh,
                             final  OnUIThreadListener<List<PostsListBean.PostList>> onUIThreadListener){

        if (isDownRefresh){//首次打开软件maxtime = null（下拉刷新传null）
            maxtime = null;
        }

        //执行网络请求
        getModel().getEssenceList(type, page, maxtime, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                if (TextUtils.isEmpty(result)){
                    //等于空----通知UI线程-----刷新UI界面
                    onUIThreadListener.onResult(null);
                }else {
                    //不等于空----解析数据
                    PostsListBean postsListBean = getGson().fromJson(result,PostsListBean.class);
                    //处理分页的逻辑----UI只负责显示数据，不要做任何与网络相关的逻辑处理
                    if (postsListBean != null && postsListBean.getInfo() != null){
                        maxtime = postsListBean.getInfo().getMaxtime();
                    }

                    if (isDownRefresh){
                        page = 0;
                    }else {
                        page++;
                    }


                    onUIThreadListener.onResult(postsListBean.getList());
                }
            }
        });
    }
}
