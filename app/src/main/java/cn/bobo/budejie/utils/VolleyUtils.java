package cn.bobo.budejie.utils;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

/**
 * Created by Leon on 2018/10/2
 * Functions: 自定义加载图片的工具类
 */
public class VolleyUtils {

    //NetworkImageView ->  ImageView
    public static void loadImage(Context context, NetworkImageView imageView, String url){

        RequestQueue queue = Volley.newRequestQueue(context);

        ImageLoader imageLoader = new ImageLoader(queue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String s) {
                return null;
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {

            }
        });

        imageView.setImageUrl(url,imageLoader);
    }

}
