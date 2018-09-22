package cn.bobo.budejie.http.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by Leon on 2018/9/22.
 * Functions: 从输入流中读取数据
 */
public class StreamTool {

    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1){
            outputStream.write(buffer,0,len);
        }
        byte[] data = outputStream.toByteArray();
        outputStream.close();
        inStream.close();
        return data;
    }

}
