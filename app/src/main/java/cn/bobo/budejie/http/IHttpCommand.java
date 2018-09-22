package cn.bobo.budejie.http;


/**
 * Created by Leon on 2018/9/22.
 * Functions: 请求参数封装
 */
public interface IHttpCommand<T> {
    public String execute(String url,IRequestParam<T> requestParam);
}
