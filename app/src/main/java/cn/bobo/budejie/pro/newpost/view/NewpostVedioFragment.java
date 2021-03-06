package cn.bobo.budejie.pro.newpost.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;

import java.util.ArrayList;
import java.util.List;

import cn.bobo.budejie.R;
import cn.bobo.budejie.bean.PostsListBean;
import cn.bobo.budejie.mvp.presenter.impl.MvpBaseaPresenter;
import cn.bobo.budejie.pro.base.presenter.BasePresener;
import cn.bobo.budejie.pro.base.view.BaseFragment;
import cn.bobo.budejie.pro.essence.presenter.EssenceVideoPresenter;
import cn.bobo.budejie.pro.essence.view.adapter.EssenceVideoAdapter;
import cn.bobo.budejie.pro.newpost.presenter.NewpostVideoPresenter;
import cn.bobo.budejie.utils.ToastUtil;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by Leon on 2018/9/16.
 * Functions:
 */
public class NewpostVedioFragment extends BaseFragment {

    private int mType = 0;
    private String mTitle;

    private NewpostVideoPresenter presenter;

    private RecyclerView recyclerView;
    private XRefreshView xRefreshView;
    private EssenceVideoAdapter videoAdapter;
    private List<PostsListBean.PostList> postList = new ArrayList<>();

    public void setType(int mType){
        this.mType = mType;
    }

    public void setTitle(String mTitle){
        this.mTitle = mTitle;
    }

    //-----------------------------leon----------------------------------
    @Override
    public NewpostVideoPresenter bindPresenter() {
        presenter = new NewpostVideoPresenter(getContext());
        return presenter;
    }
    //-----------------------------leon----------------------------------

    @Override
    public int getContentView() {
        return R.layout.fragment_essence_video;
    }

    @Override
    public void initContentView(View contentView) {
//        TextView textView = (TextView)contentView.findViewById(R.id.tv_content);
//        textView.setText(this.mTitle);

        //----------------------leon---------------------------------------
        xRefreshView = (XRefreshView)contentView.findViewById(R.id.xrefreshview);
        //设置是否可以下拉刷新
        xRefreshView.setPullRefreshEnable(true);
        //设置是否可以上拉加载
        xRefreshView.setPullLoadEnable(true);
        //设置刷新完以后，headerview固定的时间
        xRefreshView.setPinnedTime(1000);
        //静态加载模式不能设置foot view
        //设置支持自动刷新
        xRefreshView.setAutoLoadMore(true);
        //设置静默加载时提前加载的item的个数
        xRefreshView.setPreLoadCount(1);

        recyclerView = (RecyclerView)contentView.findViewById(R.id.recycler_view_test_rv);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        videoAdapter = new EssenceVideoAdapter(postList,getContext());
        recyclerView.setAdapter(videoAdapter);
        videoAdapter.setCustomLoadMoreView(new XRefreshViewFooter(getContext()));

        //-----------------------------------用户滚动RecyclerView停止播-----------------------------------------
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


                switch (newState) {
                    case 0: //滚动停止0
                        break;
                    case 1: //手指拖动1 这里先这样处理：只要用户滚动就先释放节操播放器-即停止播放
                        JCVideoPlayer.releaseAllVideos();
                        break;
                    case 2: //惯性滚动2
                        break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        //-----------------------------------用户滚动RecyclerView停止播---------------------------------------

        xRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener(){
            @Override
            public void onRefresh() {
                super.onRefresh();
                loadData(true);
            }

            @Override
            public void onLoadMore(boolean isSlience) {
                super.onLoadMore(isSlience);
                loadData(false);
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        loadData(true);
    }

    private void loadData(final boolean isDownRefresh){
        presenter.getEssenceList(mType, isDownRefresh, new BasePresener.OnUIThreadListener<List<PostsListBean.PostList>>() {
            @Override
            public void onResult(List<PostsListBean.PostList> result) {

                if (isDownRefresh){//下拉刷新
                    //停止下拉刷新
                    xRefreshView.stopRefresh();
                }else {
                    //停止加载更多
                    if (result != null && result.size() > 1 && videoAdapter.getAdapterItemCount() > 1) {
                        xRefreshView.stopLoadMore();
                    }
                }

                if (result == null){
                    ToastUtil.showToast(getContext(),"加载失败请检查网络");
                }else {
                    ToastUtil.showToast(getContext(),"加载成功");
                    //刷新UI
                    if (isDownRefresh){
                        //下拉刷新,清空列表
                        postList.clear();
                    }
                    postList.addAll(result);
                    videoAdapter.notifyDataSetChanged();
                }
            }
        });
    }

}
