package cn.bobo.budejie.http;

/**
 * Created by Leon on 2018/9/22.
 * Functions:
 */
public interface IRequestParam<T> {

    public void put(String key,Object value);

    public Object get(String key);

    public int size();

    public T getRequestParam();

}
