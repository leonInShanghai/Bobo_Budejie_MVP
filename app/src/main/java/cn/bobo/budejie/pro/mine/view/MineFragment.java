package cn.bobo.budejie.pro.mine.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import cn.bobo.budejie.R;
import cn.bobo.budejie.pro.base.view.BaseFragment;
import cn.bobo.budejie.pro.essence.view.navigation.EssenceNavigationBuilder;
import cn.bobo.budejie.pro.mine.view.navigation.MineNavigationBuilder;
import cn.bobo.budejie.utils.ToastUtil;

/**
 * Created by Leon on 2018/9/9.
 * Functions:
 */
public class MineFragment extends BaseFragment{


    @Override
    public int getContentView() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initContentView(View viewContent) {
        initToolBar(viewContent);
    }

    private void initToolBar(View viewContent){
        MineNavigationBuilder builder = new MineNavigationBuilder(getContext());

        //遇到编译不通过的时候改变一下方法的顺序@drawable/main_mine_night_model_normal
        builder.setModelRes(R.drawable.main_mine_night_model_selector)
                .setModelOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ToastUtil.showToast(getContext(),"点击了");
                    }
                })
                .setTitle(R.string.main_mine_title_text)
                .setRightIcon(R.drawable.main_mine_setting_selector)
                .setRightIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ToastUtil.showToast(getContext(),"点击了");
                        Log.e("leon","click");
                    }
                });
        builder.createAndBind((ViewGroup)viewContent);
    }
}
