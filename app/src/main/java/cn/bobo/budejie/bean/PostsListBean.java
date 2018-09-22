package cn.bobo.budejie.bean;

import java.util.List;

/**
 * Created by Leon on 2018/9/22.
 * Functions:
 */
public class PostsListBean {

    /**
     * info : {"count":2000,"page":100,"maxid":"1434209161","maxtime":"1434209161"}
     * list : [{"id":14568862,"user_id":"10924981","name":"Z-Awaiting","screen_name":"Z-Awaiting","profile_image":"http:%/%/img.spriteapp.cn%/profile%/large%/2014%/08%/28%/53fed0fda1289_mini.jpg","sina_v":"0","jie_v":"1","mid":"","url":"","from":"","created_at":"2015-06-14 12:20:58","text":"值得一看的中国宣传片\u2014\u2014如果你光明，中国便不再黑暗！","type":41,"width":"432","height":"240","tag":"","image0":"http:%/%/picture.spriteapp.com%/picture%/2015%/0613%/557bfed142f1f_24.jpg","image1":"http:%/%/picture.spriteapp.com%/picture%/2015%/0613%/557bfed142f1f_24.jpg","image2":"http:%/%/picture.spriteapp.com%/picture%/2015%/0613%/557bfed142f1f_24.jpg","image_small":"http:%/%/picture.spriteapp.com%/picture%/2015%/0613%/557bfed142f1f_24.jpg","voiceuri":"","voicetime":"","voicelength":"","videouri":"http:%/%/wvideo.spriteapp.cn%/video%/2015%/0613%/557bfed17b4a7_wpd.mp4","cdn_img":"http:%/%/picture.spriteapp.com%/picture%/2015%/0613%/557bfed142f1f_24.jpg","videotime":"264","weixin_url":"http:%/%/www.budejie.com%/budejie%/land.php?pid=14568862&wx.qq.com&appname=baisishequ","is_gif":"0","passtime":"2015-06-14 12:20:58","bookmark":"463","favourite":"463","love":"1648","hate":"30","cai":"30","comment":"33","forward":"474","repost":"474","playcount":"15761","playfcount":"2725","create_time":"2015-06-13 17:58:41","theme_id":0,"theme_type":0,"theme_name":"","themes":[{"theme_id":"55","theme_type":"1","theme_name":"微视频"}],"top_cmt":[],"status":"4","original_pid":""}]
     */

    private Info info;
    private List<PostList> list;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<PostList> getList() {
        return list;
    }

    public void setList(List<PostList> list) {
        this.list = list;
    }

    public static class Info {
        /**
         * count : 2000
         * page : 100
         * maxid : 1434209161
         * maxtime : 1434209161
         */

        private int count;
        private int page;
        private String maxid;
        private String maxtime;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getMaxid() {
            return maxid;
        }

        public void setMaxid(String maxid) {
            this.maxid = maxid;
        }

        public String getMaxtime() {
            return maxtime;
        }

        public void setMaxtime(String maxtime) {
            this.maxtime = maxtime;
        }
    }

    public static class PostList {
        /**
         * id : 14568862
         * user_id : 10924981
         * name : Z-Awaiting
         * screen_name : Z-Awaiting
         * profile_image : http:%/%/img.spriteapp.cn%/profile%/large%/2014%/08%/28%/53fed0fda1289_mini.jpg
         * sina_v : 0
         * jie_v : 1
         * mid :
         * url :
         * from :
         * created_at : 2015-06-14 12:20:58
         * text : 值得一看的中国宣传片——如果你光明，中国便不再黑暗！
         * type : 41
         * width : 432
         * height : 240
         * tag :
         * image0 : http:%/%/picture.spriteapp.com%/picture%/2015%/0613%/557bfed142f1f_24.jpg
         * image1 : http:%/%/picture.spriteapp.com%/picture%/2015%/0613%/557bfed142f1f_24.jpg
         * image2 : http:%/%/picture.spriteapp.com%/picture%/2015%/0613%/557bfed142f1f_24.jpg
         * image_small : http:%/%/picture.spriteapp.com%/picture%/2015%/0613%/557bfed142f1f_24.jpg
         * voiceuri :
         * voicetime :
         * voicelength :
         * videouri : http:%/%/wvideo.spriteapp.cn%/video%/2015%/0613%/557bfed17b4a7_wpd.mp4
         * cdn_img : http:%/%/picture.spriteapp.com%/picture%/2015%/0613%/557bfed142f1f_24.jpg
         * videotime : 264
         * weixin_url : http:%/%/www.budejie.com%/budejie%/land.php?pid=14568862&wx.qq.com&appname=baisishequ
         * is_gif : 0
         * passtime : 2015-06-14 12:20:58
         * bookmark : 463
         * favourite : 463
         * love : 1648
         * hate : 30
         * cai : 30
         * comment : 33
         * forward : 474
         * repost : 474
         * playcount : 15761
         * playfcount : 2725
         * create_time : 2015-06-13 17:58:41
         * theme_id : 0
         * theme_type : 0
         * theme_name :
         * themes : [{"theme_id":"55","theme_type":"1","theme_name":"微视频"}]
         * top_cmt : []
         * status : 4
         * original_pid :
         */

        private int id;
        private String user_id;
        private String name;
        private String screen_name;
        private String profile_image;
        private String sina_v;
        private String jie_v;
        private String mid;
        private String url;
        private String from;
        private String created_at;
        private String text;
        private int type;
        private String width;
        private String height;
        private String tag;
        private String image0;
        private String image1;
        private String image2;
        private String image_small;
        private String voiceuri;
        private String voicetime;
        private String voicelength;
        private String videouri;
        private String cdn_img;
        private String videotime;
        private String weixin_url;
        private String is_gif;
        private String passtime;
        private String bookmark;
        private String favourite;
        private String love;
        private String hate;
        private String cai;
        private String comment;
        private String forward;
        private String repost;
        private String playcount;
        private String playfcount;
        private String create_time;
        private int theme_id;
        private int theme_type;
        private String theme_name;
        private String status;
        private String original_pid;
        private List<ThemesBean> themes;
        private List<?> top_cmt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScreen_name() {
            return screen_name;
        }

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public String getSina_v() {
            return sina_v;
        }

        public void setSina_v(String sina_v) {
            this.sina_v = sina_v;
        }

        public String getJie_v() {
            return jie_v;
        }

        public void setJie_v(String jie_v) {
            this.jie_v = jie_v;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getImage0() {
            return image0;
        }

        public void setImage0(String image0) {
            this.image0 = image0;
        }

        public String getImage1() {
            return image1;
        }

        public void setImage1(String image1) {
            this.image1 = image1;
        }

        public String getImage2() {
            return image2;
        }

        public void setImage2(String image2) {
            this.image2 = image2;
        }

        public String getImage_small() {
            return image_small;
        }

        public void setImage_small(String image_small) {
            this.image_small = image_small;
        }

        public String getVoiceuri() {
            return voiceuri;
        }

        public void setVoiceuri(String voiceuri) {
            this.voiceuri = voiceuri;
        }

        public String getVoicetime() {
            return voicetime;
        }

        public void setVoicetime(String voicetime) {
            this.voicetime = voicetime;
        }

        public String getVoicelength() {
            return voicelength;
        }

        public void setVoicelength(String voicelength) {
            this.voicelength = voicelength;
        }

        public String getVideouri() {
            return videouri;
        }

        public void setVideouri(String videouri) {
            this.videouri = videouri;
        }

        public String getCdn_img() {
            return cdn_img;
        }

        public void setCdn_img(String cdn_img) {
            this.cdn_img = cdn_img;
        }

        public String getVideotime() {
            return videotime;
        }

        public void setVideotime(String videotime) {
            this.videotime = videotime;
        }

        public String getWeixin_url() {
            return weixin_url;
        }

        public void setWeixin_url(String weixin_url) {
            this.weixin_url = weixin_url;
        }

        public String getIs_gif() {
            return is_gif;
        }

        public void setIs_gif(String is_gif) {
            this.is_gif = is_gif;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }

        public String getBookmark() {
            return bookmark;
        }

        public void setBookmark(String bookmark) {
            this.bookmark = bookmark;
        }

        public String getFavourite() {
            return favourite;
        }

        public void setFavourite(String favourite) {
            this.favourite = favourite;
        }

        public String getLove() {
            return love;
        }

        public void setLove(String love) {
            this.love = love;
        }

        public String getHate() {
            return hate;
        }

        public void setHate(String hate) {
            this.hate = hate;
        }

        public String getCai() {
            return cai;
        }

        public void setCai(String cai) {
            this.cai = cai;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public String getRepost() {
            return repost;
        }

        public void setRepost(String repost) {
            this.repost = repost;
        }

        public String getPlaycount() {
            return playcount;
        }

        public void setPlaycount(String playcount) {
            this.playcount = playcount;
        }

        public String getPlayfcount() {
            return playfcount;
        }

        public void setPlayfcount(String playfcount) {
            this.playfcount = playfcount;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public int getTheme_id() {
            return theme_id;
        }

        public void setTheme_id(int theme_id) {
            this.theme_id = theme_id;
        }

        public int getTheme_type() {
            return theme_type;
        }

        public void setTheme_type(int theme_type) {
            this.theme_type = theme_type;
        }

        public String getTheme_name() {
            return theme_name;
        }

        public void setTheme_name(String theme_name) {
            this.theme_name = theme_name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getOriginal_pid() {
            return original_pid;
        }

        public void setOriginal_pid(String original_pid) {
            this.original_pid = original_pid;
        }

        public List<ThemesBean> getThemes() {
            return themes;
        }

        public void setThemes(List<ThemesBean> themes) {
            this.themes = themes;
        }

        public List<?> getTop_cmt() {
            return top_cmt;
        }

        public void setTop_cmt(List<?> top_cmt) {
            this.top_cmt = top_cmt;
        }

        public static class ThemesBean {
            /**
             * theme_id : 55
             * theme_type : 1
             * theme_name : 微视频
             */

            private String theme_id;
            private String theme_type;
            private String theme_name;

            public String getTheme_id() {
                return theme_id;
            }

            public void setTheme_id(String theme_id) {
                this.theme_id = theme_id;
            }

            public String getTheme_type() {
                return theme_type;
            }

            public void setTheme_type(String theme_type) {
                this.theme_type = theme_type;
            }

            public String getTheme_name() {
                return theme_name;
            }

            public void setTheme_name(String theme_name) {
                this.theme_name = theme_name;
            }
        }
    }
}
