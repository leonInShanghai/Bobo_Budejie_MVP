package cn.bobo.budejie.pro.newpost.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import cn.bobo.budejie.pro.essence.view.EssenceVideoFragment;
import cn.bobo.budejie.pro.newpost.view.NewpostVedioFragment;

/**
 * Created by Leon on 2018/9/16.
 * Functions:
 */
public class NewpostAdapter extends FragmentStatePagerAdapter {

    public static final String TAB_TAG = "@dream@";

    private List<String> mTitles;

    public NewpostAdapter(FragmentManager fm, List<String> mTitles) {
        super(fm);
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {

        NewpostVedioFragment fragment = new NewpostVedioFragment();
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
