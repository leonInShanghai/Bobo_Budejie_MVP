package cn.bobo.budejie.pro.newpost.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import cn.bobo.budejie.R;
import cn.bobo.budejie.pro.base.view.BaseFragment;
import cn.bobo.budejie.pro.newpost.view.adapter.NewpostAdapter;
import cn.bobo.budejie.pro.newpost.view.navigation.NewpostNavigationBuilder;
import cn.bobo.budejie.utils.ToastUtil;

/**
 * Created by Leon on 2018/9/9.
 * Functions:
 */
public class NewpostFragment extends BaseFragment{

    private TabLayout tab_newpost;
    private ViewPager vp_newpost;

    @Override
    public int getContentView() {
        return R.layout.fragment_newpost;
    }

    @Override
    public void initContentView(View viewContent) {
        initToolBar(viewContent);
//        this.tab_newpost = (TabLayout)viewContent.findViewById(R.id.tab_newpost);
//        this.vp_newpost = (ViewPager)viewContent.findViewById(R.id.vp_newpost);

        this.tab_newpost = (TabLayout)viewContent.findViewById(R.id.tab_essence);
        this.vp_newpost = (ViewPager)viewContent.findViewById(R.id.vp_essence);
    }

    private void initToolBar(View viewContent){
        NewpostNavigationBuilder builder = new NewpostNavigationBuilder(getContext());
        builder.setTitleIcon(R.drawable.main_essence_title)
                .setLeftIcon(R.drawable.main_newpost_audit_btn_selector)
                .setLeftIconOnClickLisener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ToastUtil.showToast(getContext(),"点击了");
                    }
                });
        builder.createAndBind((ViewGroup)viewContent);
    }

    @Override
    public void initData() {
        super.initData();

        String[] titles = getResources().getStringArray(R.array.newpost_video_tab);
        NewpostAdapter adapter = new NewpostAdapter(getFragmentManager(), Arrays.asList(titles));
        this.vp_newpost.setAdapter(adapter);
        this.tab_newpost.setupWithViewPager(this.vp_newpost);
    }
}
