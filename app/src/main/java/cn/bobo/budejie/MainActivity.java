package cn.bobo.budejie;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.bobo.budejie.pro.attention.view.AttentionFragment;
import cn.bobo.budejie.pro.base.view.BaseFragment;
import cn.bobo.budejie.pro.essence.view.EssenceFragment;
import cn.bobo.budejie.pro.mine.view.MineFragment;
import cn.bobo.budejie.pro.newpost.view.NewpostFragment;
import cn.bobo.budejie.pro.publish.view.PublishFragment;
import cn.bobo.budejie.utils.ToastUtil;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener{

    private List<TabItem> tabItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //由于Java OO(面向对象)的设计
        initTabData();
        initTabHost();
    }

    //初始化Tab的数据
    private void initTabData(){
        tabItemList = new ArrayList<TabItem>();

        //添加精华Tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_essence_normal,
                R.drawable.main_bottom_essence_press,R.string.main_essence_text,EssenceFragment.class));

        //添加新帖tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_newpost_normal,
                R.drawable.main_bottom_newpost_press,R.string.main_newpost_text, NewpostFragment.class));

        //添加发布（+）tab  title 没有传0
        tabItemList.add(new TabItem(R.drawable.main_bottom_public_normal,
                R.drawable.main_bottom_public_press,0, PublishFragment.class));

        //添加关注tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_attention_normal,
                R.drawable.main_bottom_attention_press,R.string.main_attention_text, AttentionFragment.class));

        //添加我的tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_mine_normal,
                R.drawable.main_bottom_mine_press,R.string.main_mine_text, MineFragment.class));
    }

    //初始化主页选项卡视图
    private void initTabHost(){
        //获取FragmentTabHost
        FragmentTabHost fragmentTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);

        //绑定TabHost(绑定我们的body)
        fragmentTabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);

        //去掉分割线
        fragmentTabHost.getTabWidget().setDividerDrawable(null);

        for (int i = 0;i < tabItemList.size();i++){
            TabItem tabItem = tabItemList.get(i);

            /**
             * 绑定Fragment（将Fragment添加到FragmentTabHost组建上面）
             * newTabSpec：代表Tab的名字
             * setIndicator：图片（今天我们采用布局文件--Tab的样式我们自己做）
             */
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(tabItem.getTitleString())
                    .setIndicator(tabItem.getView());

            /**
             * 添加Fragment
             * tabSpec：选项卡
             * getFragmentClass()：具体的Fragment
             * tabItem.getBundle()：给我们的具体fragment传参数
             */
            fragmentTabHost.addTab(tabSpec,tabItem.getFragmentClass(),tabItem.getBundle());

            //给我们的Tab按钮设置背景
            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.main_bottom_bg));

            //监听点击Tab
            fragmentTabHost.setOnTabChangedListener(this);

            //默认选中第一个Tab
            if (i == 0){
                tabItem.setChecked(true);
            }
        }
    }

    @Override
    public void onTabChanged(String tabId) {
        //ToastUtil.showToast(this,tabId);
        //切换底部tab的时候在播放中的节操播放器停止播放
        JCVideoPlayer.releaseAllVideos();
        //重置Tab样式
        for (int i = 0;i < tabItemList.size();i++){
            TabItem tabItem = tabItemList.get(i);
            if (tabId.equals(tabItem.getTitleString())){
                //选中-设置为高亮状态
                tabItem.setChecked(true);
            }else{
                //没有选中Tab样式设置为正常的
                tabItem.setChecked(false);
            }
        }
    }

    //代表每一个tab
    class TabItem{

        //正常情况下显示的图片
        private int imageNormal;

        //选中情况下显示的图片
        private int imagePress;

        //tab的名字
        private int title;
        private String titleString;

        // private Class<? extends Fragment> fragmentClass;
        private Class<? extends Fragment> fragmentClass;

        private View view;
        private ImageView imageView;
        private TextView textView;
        private Bundle bundle;

        public TabItem(int imageNormal, int imagePress, int title, Class<? extends Fragment> fragmentClass){
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.title = title;
            this.fragmentClass = fragmentClass;
        }

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }

        public int getImageNormal(){
            return imageNormal;
        }

        public int getImagePress(){
            return imagePress;
        }

        public int getTitle(){
            return title;
        }

        public String getTitleString(){

            if (title == 0){
                return "";
            }

            if (TextUtils.isEmpty(titleString)){
                titleString = getString(title);
            }

            return titleString;
        }

        public Bundle getBundle(){
            if (bundle == null){
                bundle = new Bundle();
            }

            bundle.putString("title",getTitleString());

            return bundle;
        }

        //还需要提供一个切换Tab方法--改变Tab样式
        public void setChecked(boolean isChecked){
            if (imageView != null){
                //选中的时候显示选中的图片，没有选中的时候显示没有选中的图片
                if (isChecked){
                    imageView.setImageResource(imagePress);
                }else {
                    imageView.setImageResource(imageNormal);
                }

                if (textView != null && title != 0){
                    if (isChecked){
                        textView.setTextColor(getResources().getColor(R.color.main_bottom_text_select));
                    }else {
                        textView.setTextColor(getResources().getColor(R.color.main_bottom_text_normal));
                    }
                }
            }
        }

        public View getView(){

            if (this.view == null){
                this.view = getLayoutInflater().inflate(R.layout.view_tab_indicator,null);
                this.imageView = (ImageView) this.view.findViewById(R.id.iv_tab);
                this.textView = (TextView)this.view.findViewById(R.id.tv_tab);
                if (this.title == 0) {
                    this.textView.setVisibility(View.GONE);//隐藏
                }else {
                    this.textView.setVisibility(View.VISIBLE);
                    this.textView.setText(getTitleString());
                }

                //绑定图片默认资源
                this.imageView.setImageResource(imageNormal);
            }

            return this.view;
        }
    }
}

