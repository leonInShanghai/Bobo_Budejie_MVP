package cn.bobo.budejie.pro.base.view.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cn.bobo.budejie.R;

/**
 * Created by Leon on 2018/9/9.
 * Functions:
 */
public abstract class NavigationBuilderAdapter implements NavigationBuilder {

    private Context context;
    private String title;
    private int leftIconRes;
    private int rightIconRes;
    private int titleIconRes;

    private View contentView;

    private View.OnClickListener leftIconOnClickListener;
    private View.OnClickListener rightIconOnClickListener;

    public NavigationBuilderAdapter(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public NavigationBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public NavigationBuilder setTitle(int title) {
        this.title = getContext().getResources().getString(title);
        return this;
    }

    @Override
    public NavigationBuilder setTitleIcon(int iconRes) {
        this.titleIconRes = iconRes;
        return this;
    }

    @Override
    public NavigationBuilder setLeftIcon(int iconRes) {
        this.leftIconRes = iconRes;
        return this;
    }

    @Override
    public NavigationBuilder setRightIcon(int iconRes) {
        this.rightIconRes = iconRes;
        return this;
    }

    @Override
    public NavigationBuilder setLeftIconOnClickLisener(View.OnClickListener onClickLisener) {
        this.leftIconOnClickListener = onClickLisener;
        return this;
    }

    @Override
    public NavigationBuilder setRightIconOnClickListener(View.OnClickListener onClickListener) {
        this.rightIconOnClickListener = onClickListener;
        return this;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        contentView = LayoutInflater.from(getContext()).inflate(getLayoutId(),parent,false);
        ViewGroup viewGroup = (ViewGroup)contentView.getParent();
        if (viewGroup != null){
            viewGroup.removeView(contentView);
        }
        parent.addView(contentView,0);
    }

    public void setImageViewStyle(int viewId, int imageRes, View.OnClickListener onClickListener){

        ImageView imageView = (ImageView)getContentView().findViewById(viewId);
        if (imageRes == 0){
            imageView.setVisibility(View.GONE);
        }else {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(imageRes);
            imageView.setOnClickListener(onClickListener);
        }
    }

    public View findViewById(int id){
        return getContentView().findViewById(id);
    }

    public abstract int getLayoutId();

    public View getContentView() {
        return contentView;
    }

    public int getLeftIconRes() {
        return leftIconRes;
    }

    public int getTitleIconRes() {
        return titleIconRes;
    }

    public int getRightIconRes() {
        return rightIconRes;
    }

    public View.OnClickListener getLeftIconOnClickListener() {
        return leftIconOnClickListener;
    }

    public View.OnClickListener getRightIconOnClickListener() {
        return rightIconOnClickListener;
    }

    public String getTitle() {
        return title;
    }
}

