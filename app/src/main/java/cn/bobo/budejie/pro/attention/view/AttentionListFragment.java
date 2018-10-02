package cn.bobo.budejie.pro.attention.view;

import android.view.View;

import cn.bobo.budejie.R;
import cn.bobo.budejie.pro.base.view.BaseFragment;

/**
 * Created by Leon on 2018/10/1.
 * Functions:关注列表
 */

public class AttentionListFragment extends BaseFragment{

    private int mType = 0;
    private String mTitle;

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setType(int mType) {
        this.mType = mType;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_attention_list;
    }

    @Override
    public void initContentView(View viewContent) {

    }
}
