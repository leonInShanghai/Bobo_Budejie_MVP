package cn.bobo.budejie.pro.attention.view;

import android.view.View;

import cn.bobo.budejie.R;
import cn.bobo.budejie.pro.base.view.BaseFragment;

/**
 * Created by Leon on 2018/9/24.
 * Functions: 订阅列表
 */
public class AttentionSubscriptionFrament extends BaseFragment {

    private int mType = 0;
    private String mTitle;

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
    public void initContentView(View viewContent) {

    }

    @Override
    public void initData() {
        super.initData();
    }
}
