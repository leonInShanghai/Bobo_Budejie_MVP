
package cn.bobo.budejie;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.liji.imagezoom.activity.ImageDetailFragment;
import com.liji.imagezoom.util.BottomMenuDialog;
import com.liji.imagezoom.util.ImageZoom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import cn.bobo.budejie.pro.base.view.DragScaleView;

/**
 * Created by Leon on 2018/10/21.
 * Functions: 点击查看大图activity 不支持GIF图
 */

public class PictureActivity extends AppCompatActivity implements View.OnLongClickListener {

    //自定义能显示拖动图片的view 老方法有些图片加载不出来
    private DragScaleView dragView;

    final int REQUEST_WRITE = 1001;//申请权限的请求码
    private ScrollView scrollView_le;
    private String uri;
    private ProgressBar picture_pro;
    private boolean pointOut = true;
    private WebView web_view;
    private List<String> list;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_picture);
        uri = getIntent().getStringExtra("IMAGEURL");

        //这个放方法有些图片加载不了后来不用了
        //dragView = (DragScaleView) findViewById(R.id.image);
//        //涉及到网络请求的到子线程操作
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                dragView.setImageResource(uri);
//            }
//        }.start();

        //scrollView_le = (ScrollView)findViewById(R.id.scrollView_le);
        //imageView = (ImageView) findViewById(R.id.btn_picture_viewer);

        picture_pro = (ProgressBar) findViewById(R.id.picture_pro);
        picture_pro.setVisibility(View.VISIBLE);
        web_view = (WebView) findViewById(R.id.web_view);
        web_view.loadUrl(uri);
        web_view.setOnLongClickListener(this);
        WebSettings webSettings = web_view.getSettings();

        //设置可任意缩放
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        //设置WebViewClient类
        web_view.setWebViewClient(new WebViewClient() {

            //设置加载前的函数
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                picture_pro.setVisibility(View.VISIBLE);
            }

            //设置结束加载函数
            @Override
            public void onPageFinished(WebView view, String url) {
                bitmap = returnBitMap(url);
                picture_pro.setVisibility(View.GONE);
            }
        });
    }


    //url转bitmap 的方法
    public Bitmap returnBitMap(final String url){

        new Thread(new Runnable() {
            @Override
            public void run() {
                URL imageurl = null;

                try {
                    imageurl = new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    HttpURLConnection conn = (HttpURLConnection)imageurl.openConnection();
                    conn.setDoInput(true);
                    conn.connect();
                    InputStream is = conn.getInputStream();
                    bitmap = BitmapFactory.decodeStream(is);
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return bitmap;
    }

    //activity销毁的时候移除webview 合理的管理内存
    @Override
    protected void onDestroy() {
        if (web_view != null) {
            web_view.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            web_view.clearHistory();

            ((ViewGroup) web_view.getParent()).removeView(web_view);
            web_view.destroy();
            web_view = null;
        }
        super.onDestroy();
    }

    @Override
    public boolean onLongClick(View view) {

        if (view == web_view){

            //导入了一个框架一句代码保存到相册
            ImageDetailFragment.newInstance(uri);

            final BottomMenuDialog dialog = new BottomMenuDialog.Builder()

                    .addItem("保存到本地相册", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkPermission();

                        }
                    })
                    .addItem("取消", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(PictureActivity.this, "取消", Toast.LENGTH_LONG).show();
                        }
                    })

                    .build();
            dialog.show(getSupportFragmentManager());

            return true;
        }

        return false;
    }

    private void checkPermission() {

        //判断是否6.0以上的手机   不是就不用
        if (Build.VERSION.SDK_INT >= 23) {
            //判断是否有这个权限
            if (ContextCompat.checkSelfPermission(PictureActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                //2、申请权限: 参数二：权限的数组；参数三：请求码
                requestPermissions(new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE }, REQUEST_WRITE);
            }
            else {
                saveImageToGallery(PictureActivity.this,bitmap);
            }
        }
        else {
            saveImageToGallery(PictureActivity.this,bitmap);
        }
    }

    /**
     * 保存到本地相册
     * @param context
     * @param bmp
     */
    public void saveImageToGallery(Context context, Bitmap bmp) {
        Log.d("ZoomImage", "saveImageToGallery:" + bmp);
        final String SAVE_PIC_PATH = Environment.getExternalStorageState().equalsIgnoreCase(Environment.MEDIA_MOUNTED)
                ? Environment.getExternalStorageDirectory().getAbsolutePath()
                : "/mnt/sdcard";//保存到SD卡

        // 首先保存图片
        File appDir = new File(SAVE_PIC_PATH + "/波波不得姐/");
        if (!appDir.exists()) {
            appDir.mkdir();
        }

        long nowSystemTime = System.currentTimeMillis();
        String fileName = nowSystemTime + ".png";
        File file = new File(appDir, fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //保存图片后发送广播通知更新数据库
        Uri uri = Uri.fromFile(file);
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));

//        // 其次把文件插入到系统图库
//        try {
//            MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        // 最后通知图库更新
//        context.sendBroadcast(
//                new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getAbsolutePath())));
        Toast.makeText(PictureActivity.this, "已保存到本地相册", Toast.LENGTH_LONG).show();
    }
}


