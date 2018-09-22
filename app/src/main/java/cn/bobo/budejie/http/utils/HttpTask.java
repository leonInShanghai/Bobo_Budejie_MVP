package cn.bobo.budejie.http.utils;

import android.os.AsyncTask;

import cn.bobo.budejie.http.IHttpCommand;
import cn.bobo.budejie.http.IRequestParam;
import cn.bobo.budejie.http.impl.SystemHttpCommand;

/**
 * Created by Leon on 2018/9/22.
 * Functions: 异步任务执行网络请求--公共类
 */
public class HttpTask extends AsyncTask<String,Void,String>{

    private String url;
    private IRequestParam requestParam;
    private HttpUtils.OnHttpResultListener onHttpResultListener;
    private IHttpCommand httpCommand;

    public HttpTask(String url, IRequestParam requestParam, HttpUtils.OnHttpResultListener
            onHttpResultListener, SystemHttpCommand httpCommand) {
        this.url = url;
        this.requestParam = requestParam;
        this.onHttpResultListener = onHttpResultListener;
        this.httpCommand = httpCommand;
    }

    @Override
    protected String doInBackground(String... strings) {

        return httpCommand.execute(url,requestParam);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (this.onHttpResultListener != null){
            this.onHttpResultListener.onResult(result);
        }
    }
}
