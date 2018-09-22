package cn.bobo.budejie.pro.newpost.view.navigation;

import android.content.Context;

import cn.bobo.budejie.R;
import cn.bobo.budejie.pro.base.view.navigation.NavigationBuilderAdapter;

/**
 * Created by Leon on 2018/9/9.
 * Functions:
 */
public class NewpostNavigationBuilder extends NavigationBuilderAdapter{

    public NewpostNavigationBuilder(Context context){
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_newpost_layout;
    }
}
