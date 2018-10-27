package cn.bobo.budejie.pro.publish.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import cn.bobo.budejie.R;
import cn.bobo.budejie.mvp.presenter.impl.MvpBaseaPresenter;
import cn.bobo.budejie.pro.base.view.BaseFragment;

/**
 * Created by Leon on 2018/9/9.
 * Functions:
 */
public class PublishFragment extends BaseFragment{

    private ImageView image_icon;

    private boolean resume;

    @Override
    public int getContentView() {
        return R.layout.fragment_publish;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void initContentView(View viewContent) {


        image_icon = viewContent.findViewById(R.id.image_icon);

        ValueAnimator animator = ValueAnimator.ofFloat(0, 360);
        animator.setDuration(2000);
        animator.setInterpolator(new AccelerateInterpolator());
        //动画循环INFINITE 无限循环
        animator.setRepeatCount(ValueAnimator.INFINITE);
        if (resume){
            animator.setRepeatMode(ValueAnimator.RESTART);
        }else {
            animator.setRepeatMode(ValueAnimator.REVERSE);
        }
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float)valueAnimator.getAnimatedValue();
                image_icon.setRotationY(value);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
         animator.addPauseListener(new Animator.AnimatorPauseListener(){

                @Override
                public void onAnimationPause(Animator animator) {

                }

                @Override
                public void onAnimationResume(Animator animator) {
                    resume = !resume;
                }
            });
        }
        animator.start();



    }
}
