package cn.bobo.budejie.bean;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

public class AttentionSubscriptionBean {

    /**
     * theme_id : 163
     * theme_name : 生活百科
     * image_list : http:%/%/img.spriteapp.cn%/ugc%/2015%/04%/23%/160559_24190.jpg
     * sub_number : 36871
     * is_sub : 0
     * is_default : 0
     */

    public AttentionSubscriptionBean(){
        Gson gson = new Gson();
        try {
            JSONArray jsonArray = new JSONArray("");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String theme_id;
    private String theme_name;
    private String image_list;
    private String sub_number;
    private int is_sub;
    private int is_default;

    public String getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(String theme_id) {
        this.theme_id = theme_id;
    }

    public String getTheme_name() {
        return theme_name;
    }

    public void setTheme_name(String theme_name) {
        this.theme_name = theme_name;
    }

    public String getImage_list() {
        return image_list;
    }

    public void setImage_list(String image_list) {
        this.image_list = image_list;
    }

    public String getSub_number() {
        return sub_number;
    }

    public void setSub_number(String sub_number) {
        this.sub_number = sub_number;
    }

    public int getIs_sub() {
        return is_sub;
    }

    public void setIs_sub(int is_sub) {
        this.is_sub = is_sub;
    }

    public int getIs_default() {
        return is_default;
    }

    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }
}
