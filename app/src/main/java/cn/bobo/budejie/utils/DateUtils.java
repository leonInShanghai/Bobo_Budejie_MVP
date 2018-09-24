package cn.bobo.budejie.utils;

import android.icu.text.SimpleDateFormat;
import java.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by Leon on 2018/9/23.
 * Functions:
 */
public class DateUtils {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String parseDate(String createTime) {
        try {
            String ret = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long create = sdf.parse(createTime).getTime();
            Calendar now = Calendar.getInstance();
            long ms = 1000 * (now.get(Calendar.HOUR_OF_DAY) * 3600 + now.get(Calendar.MINUTE) * 60 + now.get(Calendar.SECOND));//毫秒数
            long ms_now = now.getTimeInMillis();
            if (ms_now - create < ms) {
                ret = "今天 " + createTime.substring(createTime.indexOf(" ") + 1);
            } else if (ms_now - create < (ms + 24 * 3600 * 1000)) {
                ret = "昨天 " + createTime;
            } else if (ms_now - create < (ms + 24 * 3600 * 1000 * 2)) {
                ret = "前天 " + createTime;
            } else {
                ret = "更早 " + createTime;
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}