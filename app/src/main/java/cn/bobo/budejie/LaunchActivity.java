package cn.bobo.budejie;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import cn.bobo.budejie.MainActivity;

/**
 * Created by Leon on 2018/9/2.
 * Functions: 启动页面（非引导页）
 */
public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        /**总结：启动页有4中解决方案（企业级开发主要就是这4中方案）
         * ①：属性动画object animator实现
         * ②：补间动画实现（例如：TranslateAnimation ScaleAnimation AlphaAnimation RotateAnimation）
         * ③：定时器Timer实现
         * ④：Handler + Thread 实现 --- AsyncTask封装
         */

        //①：属性动画object animator实现
        LinearLayout target = findViewById(R.id.iv_bg);

        /**
         * 第一个参数：target：你要对那个view绑定动画
         * 第二个参数：propertyName你要执行什么动画-动画的属性名称 "scaleX"：缩放动画 "alpha"：渐变动画
         * 第三个参数：动画的变化范围（例如：缩放动画的范围0.0 - 1.0 之间）
         */
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(target,"alpha",0.5f,1.0f);

        //设置动画执行的时间(企业级开发执行时间一般情况2-3秒钟)
        objectAnimator.setDuration(2000);

        //启动动画
        objectAnimator.start();


        /** 动画执行完毕启动main activity
         *  扩展知识点--设计模式--适配器
         *  项目开发需要定义很多的接口
         *  Google工程师想到了你再开发中很多方法用不到
         */
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //动画结束启动main activity
                startActivity(new Intent(LaunchActivity.this,MainActivity.class));
                //启动完以后关闭启动页（本页面）
                finish();
            }
        });

//        Google工程师想到了你再开发中很多方法用不到  这是老方法↓ 新方法↑
//        objectAnimator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                //动画结束启动main activity
//                startActivity(new Intent(LaunchActivity.this,MainActivity.class));
//                //启动完以后关闭启动页（本页面）
//                finish();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//
//            }
//        });
    }
}

