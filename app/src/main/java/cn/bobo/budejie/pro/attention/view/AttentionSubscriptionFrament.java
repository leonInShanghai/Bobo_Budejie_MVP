package cn.bobo.budejie.pro.attention.view;

import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.bobo.budejie.R;
import cn.bobo.budejie.bean.AttentionSubscriptionBean;
import cn.bobo.budejie.pro.attention.presenter.AttentionSubscriptionPresenter;
import cn.bobo.budejie.pro.attention.view.adapter.AttentionAdapter;
import cn.bobo.budejie.pro.attention.view.adapter.AttentionSubscriptionAdapter;
import cn.bobo.budejie.pro.base.presenter.BasePresener;
import cn.bobo.budejie.pro.base.view.BaseFragment;

/**
 * Created by Leon on 2018/9/24.
 * Functions: 订阅列表
 */
public class AttentionSubscriptionFrament extends BaseFragment<AttentionSubscriptionPresenter> {

    private int mType = 0;
    private String mTitle;
    private AttentionSubscriptionAdapter subscriptionAdapter;
    private List<AttentionSubscriptionBean> subscriptionBeanList = new ArrayList<AttentionSubscriptionBean>();

    @Override
    public AttentionSubscriptionPresenter bindPresenter() {
        return new AttentionSubscriptionPresenter(getContext());
    }

    public void setType(int mType) {
        this.mType = mType;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_attention_subscription;
    }

    @Override
    public void initContentView(View contentView) {
        ListView lv_attention = (ListView) contentView.findViewById(R.id.lv_attention);
        subscriptionAdapter = new AttentionSubscriptionAdapter(getContext(),subscriptionBeanList);
        lv_attention.setAdapter(subscriptionAdapter);
    }

    @Override
    public void initData() {
        super.initData();
        loadData(1);
    }

    private void loadData(int mType){
        getPresenter().getAttentionSubscriptionList(mType, new BasePresener.OnUIThreadListener<List<AttentionSubscriptionBean>>() {
            @Override
            public void onResult(List<AttentionSubscriptionBean> result) {
                if (result != null){
                    //刷新适配器
                    subscriptionBeanList.addAll(result);
                    subscriptionAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
