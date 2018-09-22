package cn.bobo.budejie.pro.essence.view;

import android.view.View;
import android.widget.TextView;

import java.util.List;

import cn.bobo.budejie.R;
import cn.bobo.budejie.bean.PostsListBean;
import cn.bobo.budejie.mvp.presenter.impl.MvpBaseaPresenter;
import cn.bobo.budejie.pro.base.presenter.BasePresener;
import cn.bobo.budejie.pro.base.view.BaseFragment;
import cn.bobo.budejie.pro.essence.presenter.EssenceVideoPresenter;
import cn.bobo.budejie.utils.ToastUtil;

/**
 * Created by Leon on 2018/9/16.
 * Functions:
 */
public class EssenceVideoFragment extends BaseFragment {

    private int mType = 0;
    private String mTitle;

    private EssenceVideoPresenter presenter;

    public void setType(int mType){
        this.mType = mType;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public MvpBaseaPresenter bindPresenter() {
        presenter = new EssenceVideoPresenter(getContext());
        return presenter;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_essence_video;
    }

    @Override
    public void initContentView(View viewContent) {

    }

    @Override
    public void initData() {
        super.initData();
        loadData(true);
    }

    private void loadData(boolean isDownRefresh){
        presenter.getEssenceList(mType, isDownRefresh, new BasePresener.OnUIThreadListener<List<PostsListBean.PostList>>() {
            @Override
            public void onResult(List<PostsListBean.PostList> result) {
                if (result == null){
                    ToastUtil.showToast(getContext(),"加载失败请检查网络");
                }else {
                    ToastUtil.showToast(getContext(),"加载成功");
                }
            }
        });
    }
}
