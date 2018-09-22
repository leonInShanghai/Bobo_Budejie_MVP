package cn.bobo.budejie.http.impl;

import java.util.HashMap;

import cn.bobo.budejie.http.IRequestParam;

/**
 * Created by Leon on 2018/9/22.
 * Functions:
 */
public class RequestParam implements IRequestParam<HashMap<String,Object>> {

    private HashMap<String,Object> paramMap = new HashMap<String,Object>();

    @Override
    public void put(String key, Object value) {
        paramMap.put(key,value);
    }

    @Override
    public Object get(String key) {
        return paramMap.get(key);
    }

    @Override
    public int size() {
        return paramMap.size();
    }

    @Override
    public HashMap<String, Object> getRequestParam() {
        return paramMap;
    }
}
