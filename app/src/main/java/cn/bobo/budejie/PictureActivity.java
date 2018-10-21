package cn.bobo.budejie;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;

import cn.bobo.budejie.pro.base.view.DragScaleView;

/**
 * Created by Leon on 2018/10/21.
 * Functions: 点击查看大图activity 不支持GIF图
 */

public class PictureActivity extends AppCompatActivity {

    private DragScaleView dragView;
    private Dialog dialog;
    private ImageView mImageView;
    private String url;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        url = getIntent().getStringExtra("IMAGEURL");

        dragView = (DragScaleView)findViewById(R.id.image);

        //涉及到网络请求的到子线程操作
        new Thread(){
            @Override
            public void run() {
                super.run();
                dragView.setImageResource(url);
            }
        }.start();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //将点击事件传递给子控件处理
        return dragView.onTouchEvent(event);
    }

}
