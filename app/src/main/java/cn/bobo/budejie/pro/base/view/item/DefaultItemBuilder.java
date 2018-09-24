package cn.bobo.budejie.pro.base.view.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.bobo.budejie.R;

/**
 * Created by Leon on 2018/9/24.
 * Functions:
 */
public class DefaultItemBuilder extends AbsItemBuilder {

    private int leftIconRes;
    private int rightIconRes;
    private String text;
    private View.OnClickListener onClickListener;


    public DefaultItemBuilder(Context context) {
        super(context);
    }

    @Override
    public int getContentView() {
        return R.layout.item_build_default;
    }

    public DefaultItemBuilder setLeftIcon(int leftIconRes){
        this.leftIconRes = leftIconRes;
        return this;
    }

    public DefaultItemBuilder setLeftText(int textRes){
        return setLeftText(getContext().getString(textRes));
    }

    public DefaultItemBuilder setLeftText(String text){
        this.text = text;
        return this;
    }

    public DefaultItemBuilder setRightIcon(int rightIconRes){
        this.rightIconRes = rightIconRes;
        return this;
    }

    public DefaultItemBuilder setOnItemClickListener(View.OnClickListener onItemClickListener){
        this.onClickListener = onItemClickListener;
        return this;
    }

    @Override
    public View buildAndBind(ViewGroup parent) {

        View view = super.buildAndBind(parent);
        ImageView iv_left = (ImageView) view.findViewById(R.id.iv_left);
        if (leftIconRes >= 0){
            iv_left.setImageResource(leftIconRes);
            iv_left.setVisibility(View.VISIBLE);
        }else{
            iv_left.setVisibility(View.GONE);
        }
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        if (TextUtils.isEmpty(text)){
            tv_title.setVisibility(View.INVISIBLE);
        }else {
            tv_title.setText(text);
            tv_title.setVisibility(View.VISIBLE);
        }
        if (onClickListener != null){
            view.setOnClickListener(onClickListener);
        }

        return view;
    }

}

