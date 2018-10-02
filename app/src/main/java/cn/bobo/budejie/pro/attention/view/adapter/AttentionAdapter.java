package cn.bobo.budejie.pro.attention.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import cn.bobo.budejie.pro.attention.view.AttentionListFragment;
import cn.bobo.budejie.pro.attention.view.AttentionSubscriptionFrament;

/**
 * Created by Leon on 2018/10/1
 * Functions: 关注的适配器-初始化ViewPager,加载Fragment
 */

public class AttentionAdapter extends FragmentStatePagerAdapter {

    public static final String TAB_TAG = "@dream@";
    private List<String> mTitles;

    public  AttentionAdapter(FragmentManager fm, List<String> titles){
        super(fm);
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            AttentionSubscriptionFrament frament = new AttentionSubscriptionFrament();
            String[] title = mTitles.get(position).split(TAB_TAG);
            frament.setType(Integer.parseInt(title[1]));
            frament.setTitle(title[0]);
            return frament;
        }
        AttentionListFragment fragment = new AttentionListFragment();
        String[] title = mTitles.get(position).split(TAB_TAG);
        fragment.setType(Integer.parseInt(title[1]));
        fragment.setTitle(title[0]);
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position).split(TAB_TAG)[0];
    }

}
