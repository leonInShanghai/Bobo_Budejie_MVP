package cn.bobo.budejie.pro.attention.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import cn.bobo.budejie.R;
import cn.bobo.budejie.pro.attention.view.navation.AttentionNavigationBuilder;
import cn.bobo.budejie.pro.base.view.BaseFragment;
import cn.bobo.budejie.pro.essence.view.adapter.EssenceAdapter;

/**
 * Created by Leon on 2018/9/9.
 * Functions:
 */
public class AttentionFragment extends BaseFragment{

    @Override
    public int getContentView() {
        return R.layout.fragment_attention;
    }

    @Override
    public void initContentView(View viewContent) {
        ViewPager vp_atteention = (ViewPager)viewContent.findViewById(R.id.vp_attention);
        String[] titles = getResources().getStringArray(R.array.attention_video_tab);
        EssenceAdapter adapter = new EssenceAdapter(getFragmentManager(), Arrays.asList(titles));
        vp_atteention.setAdapter(adapter);
        initToolBar(viewContent,vp_atteention);
    }

    private void initToolBar(View contentView,ViewPager viewPager){
        AttentionNavigationBuilder builder = new AttentionNavigationBuilder(getContext());
        builder.setUpWithViewPager(viewPager)
                .setLeftIcon(R.drawable.main_newpost_audit_btn_selector)
                .setLeftIconOnClickLisener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
        ViewGroup parentView = (ViewGroup)contentView;
        builder.createAndBind(parentView);
    }
}
