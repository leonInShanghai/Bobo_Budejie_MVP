package cn.bobo.budejie.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Leon on 2018/10/2
 * Functions: 自定义 GSON 解析工具类
 */
public class GsonUtils<T> {

    /**
     * 两种方案：
     * 第一种：方法泛型
     * 第二种：类的泛型
     */


    /**
     * 方法泛型使用：方法一
     * @param result
     * @param clazz
     * @return
     */
    public  ArrayList<T>  parseArray(String result, Class<?> clazz) {

        ArrayList<T>  list = new ArrayList<T>();


        return null;
    }

    /**
     * 方法泛型使用：方法二
     * @param <T>
     * @return
     */
    public static <T> List<T> getList(String result, Class<T> clazz){

        List<T> list = new ArrayList<T>();
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement el = parser.parse(result);
        Iterator it = el.getAsJsonArray().iterator();

        while (it.hasNext()){
            JsonElement e = (JsonElement)it.next();
            //JsonElement转换为javabean对象
            T model = gson.fromJson(e,clazz);
            list.add(model);
        }

        return list;
    }

}
