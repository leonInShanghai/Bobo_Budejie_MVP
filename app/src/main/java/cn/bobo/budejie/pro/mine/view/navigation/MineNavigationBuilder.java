package cn.bobo.budejie.pro.mine.view.navigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import cn.bobo.budejie.R;
import cn.bobo.budejie.pro.base.view.navigation.NavigationBuilderAdapter;

/**
 * Created by Leon on 2018/9/9.
 * Functions:
 */
public class MineNavigationBuilder extends NavigationBuilderAdapter{

    private int modelRes;
    private View.OnClickListener modelOnClickListener;

    public MineNavigationBuilder(Context context){
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_mine_layout;
    }

    public MineNavigationBuilder setModelRes(int modelRes){
        this.modelRes = modelRes;
        return this;
    }

    public MineNavigationBuilder setModelOnClickListener(View.OnClickListener onClickListener){
        this.modelOnClickListener = onClickListener;
        return this;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_model,modelRes,this.modelOnClickListener);
        setImageViewStyle(R.id.iv_setting,getRightIconRes(),getRightIconOnClickListener());
    }
}
