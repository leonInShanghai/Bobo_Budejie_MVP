package cn.bobo.budejie.pro.attention.view.navation;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import cn.bobo.budejie.R;
import cn.bobo.budejie.pro.base.view.navigation.NavigationBuilderAdapter;

/**
 * Created by Leon on 2018/9/16.
 * Functions:
 */
public class AttentionNavigationBuilder extends NavigationBuilderAdapter {

    private ViewPager viewPager;

    public AttentionNavigationBuilder(Context context){
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_attention_layout;
    }

    public AttentionNavigationBuilder setUpWithViewPager(ViewPager viewPager){
        this.viewPager = viewPager;
        return this;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_left,getLeftIconRes(),getLeftIconOnClickListener());
        TabLayout tab_attention = (TabLayout)findViewById(R.id.tab_attention);
        tab_attention.setupWithViewPager(viewPager);
    }
}
