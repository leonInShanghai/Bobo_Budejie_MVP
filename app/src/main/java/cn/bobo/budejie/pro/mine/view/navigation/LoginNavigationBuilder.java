package cn.bobo.budejie.pro.mine.view.navigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import cn.bobo.budejie.R;

import cn.bobo.budejie.pro.base.view.navigation.NavigationBuilderAdapter;

/**
 * Created by Leon on 2018/9/24.
 * Functions:
 */
public class LoginNavigationBuilder extends NavigationBuilderAdapter{

    private View.OnClickListener titleOnClickListener;

    public LoginNavigationBuilder(Context context){
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_login_layout;
    }

    public LoginNavigationBuilder setTitleOnClickListener(View.OnClickListener titleOnClickListener){
        this.titleOnClickListener = titleOnClickListener;
        return this;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_left,getLeftIconRes(),getLeftIconOnClickListener());
        setTitleTextView(R.id.tv_title,getTitle(),titleOnClickListener);
    }
}
