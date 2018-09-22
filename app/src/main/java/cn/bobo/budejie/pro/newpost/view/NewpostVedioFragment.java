package cn.bobo.budejie.pro.newpost.view;

import android.view.View;
import android.widget.TextView;

import cn.bobo.budejie.R;
import cn.bobo.budejie.pro.base.view.BaseFragment;

/**
 * Created by Leon on 2018/9/16.
 * Functions:
 */
public class NewpostVedioFragment extends BaseFragment {

    private int mType = 0;
    private String mTitle;

    public void setType(int mType){
        this.mType = mType;
    }

    public void setTitle(String mTitle){
        this.mTitle = mTitle;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_essence_video;
    }

    @Override
    public void initContentView(View viewContent) {
        TextView textView = (TextView)viewContent.findViewById(R.id.tv_content);
        textView.setText(this.mTitle);
    }
}
