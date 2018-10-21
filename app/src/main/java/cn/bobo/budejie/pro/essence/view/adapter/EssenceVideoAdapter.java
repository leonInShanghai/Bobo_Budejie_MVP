package cn.bobo.budejie.pro.essence.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;

import cn.bobo.budejie.PictureActivity;
import cn.bobo.budejie.utils.DateUtils;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.bumptech.glide.Glide;

import java.util.List;

import cn.bobo.budejie.R;
import cn.bobo.budejie.bean.PostsListBean;
import cn.bobo.budejie.pro.essence.view.views.CircleNetworkImageImage;
import cn.bobo.budejie.utils.VolleyUtils;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Leon on 2018/9/23.
 * Functions:
 */
public class EssenceVideoAdapter extends BaseRecyclerAdapter<EssenceVideoAdapter.VideoAdapterViewHolder> {

    private Context context;
    private List<PostsListBean.PostList> list;

    public EssenceVideoAdapter(List<PostsListBean.PostList> list,Context context){
        this.context = context;
        this.list = list;
    }

    /**
     * 配置viewholder
     * @param view
     * @return
     */
    @Override
    public VideoAdapterViewHolder getViewHolder(View view) {
        return new VideoAdapterViewHolder(view,false);
    }

    /**
     * 创建布局
     * @param parent
     * @param viewType
     * @param isItem
     * @return
     */
    @Override
    public VideoAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_essence_video_layout,parent,
                false);
        VideoAdapterViewHolder holder = new VideoAdapterViewHolder(v,true);
        return holder;
    }

    /**
     * 给我们的视图绑定数据
     * @param holder
     * @param position
     * @param isItem
     */
    //@RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(VideoAdapterViewHolder holder, int position, boolean isItem) {
        final PostsListBean.PostList postList = this.list.get(position);
        VolleyUtils.loadImage(context,holder.iv_header,postList.getProfile_image());
        //loadImage(holder.iv_header,postList.getProfile_image());
        holder.tv_name.setText(postList.getName());
        holder.tv_time.setText(DateUtils.parseDate(postList.getCreate_time()));
        holder.tv_content.setText(postList.getText());
        holder.tv_like.setText(postList.getDing());//favourite
        holder.tv_dislike.setText(postList.getCai());
        holder.tv_forword.setText(postList.getRepost());
        holder.tv_comment.setText(postList.getComment());


        // 帖子的类型，1为全部 10为图片 29为段子 31为音频 41为视频
        switch (postList.getType()){
            case 10: //10为图片
                //.placeholder(R.drawable.timg)
                holder.iv_10.setImageResource(R.drawable.timg);
                Glide.with(context).load(postList.getImage0()).into(holder.iv_10);
                holder.iv_10.setVisibility(View.VISIBLE);
               if (postList.getIs_gif().equals("0")){//如果是非GIF图片支持查看大图。
                    // 点击事件的处理
                    holder.iv_10.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context,PictureActivity.class);
                            intent.putExtra("IMAGEURL",postList.getImage0());
                            context.startActivity(intent);
                        }
                    });
                }
                holder.iv_video.setVisibility(View.GONE);
                holder.iv_41.setVisibility(View.GONE);
                break;
            case 29: //29为段子
                holder.iv_10.setVisibility(View.GONE);
                holder.iv_video.setVisibility(View.GONE);
                holder.iv_41.setVisibility(View.GONE);
                break;
            case 41: //41为视频
                holder.iv_41.TOOL_BAR_EXIST = false;
                // holder.iv_41.setUp(postList.getVideouri()
                //                        , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "播放视频的标题，可以为空");
                holder.iv_41.setUp(postList.getVideouri()
                        , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
                //holder.iv_41.loop  = true;//是否循环播放
                Glide.with(context).load(postList.getVideouri()).into(holder.iv_41.thumbImageView);
                holder.iv_41.widthRatio = 4;//播放比例
                holder.iv_41.heightRatio = 3;
                holder.iv_10.setVisibility(View.GONE);
                holder.iv_video.setVisibility(View.GONE);
                holder.iv_41.setVisibility(View.VISIBLE);
                break;
            default :
                holder.iv_41.setVisibility(View.GONE);
                holder.iv_10.setVisibility(View.GONE);
                holder.iv_video.setVisibility(View.VISIBLE);
                break;
        }

    }

    @Override
    public int getAdapterItemCount() {
        return this.list.size();
    }

    /**
     * 这个方法已经封装到工具类
     */
//    private void loadImage(NetworkImageView imageView,String url){
//        RequestQueue queue = Volley.newRequestQueue(context);
//        ImageLoader imageLoader = new ImageLoader(queue, new ImageLoader.ImageCache() {
//            @Override
//            public void putBitmap(String s, Bitmap bitmap) {
//
//            }
//            @Override
//            public Bitmap getBitmap(String s) {
//                return null;
//            }
//        });
//        imageView.setImageUrl(url,imageLoader);
//    }

    public class VideoAdapterViewHolder extends RecyclerView.ViewHolder{

        public CircleNetworkImageImage iv_header;
        public TextView tv_name;
        public TextView tv_time;
        public TextView tv_content;

        //处理类型41 视频
        public JCVideoPlayerStandard iv_41;

        //处理类型10 图片image view
        public ImageView iv_10;

        //占位image view
        public ImageView iv_video;

        public LinearLayout ll_like;
        public TextView tv_like;

        public LinearLayout ll_dislike;
        public TextView tv_dislike;

        public LinearLayout ll_forword;
        public TextView tv_forword;

        public LinearLayout ll_comment;
        public TextView tv_comment;

        public int position;

        public VideoAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem){
               iv_header = (CircleNetworkImageImage) itemView.findViewById(R.id.iv_header);
                tv_name = (TextView) itemView
                        .findViewById(R.id.tv_name);
                tv_time = (TextView) itemView
                        .findViewById(R.id.tv_time);
                tv_content = (TextView) itemView
                        .findViewById(R.id.tv_content);

                //处理类型41 视频item
                iv_41 =  (JCVideoPlayerStandard)itemView.findViewById(R.id.iv_41);

                //处理类型10 图片item
                iv_10 = (ImageView)itemView.findViewById(R.id.iv_10);

                //占位image view
                iv_video = (ImageView) itemView
                        .findViewById(R.id.iv_video);

                ll_like = (LinearLayout) itemView
                        .findViewById(R.id.ll_like);
                tv_like = (TextView) itemView
                        .findViewById(R.id.tv_like);

                ll_dislike = (LinearLayout) itemView
                        .findViewById(R.id.ll_dislike);
                tv_dislike = (TextView) itemView
                        .findViewById(R.id.tv_dislike);

                ll_forword = (LinearLayout) itemView
                        .findViewById(R.id.ll_forword);
                tv_forword = (TextView) itemView
                        .findViewById(R.id.tv_forword);

                ll_comment = (LinearLayout) itemView
                        .findViewById(R.id.ll_comment);
                tv_comment = (TextView) itemView
                        .findViewById(R.id.tv_comment);

            }
        }
    }
    
}
