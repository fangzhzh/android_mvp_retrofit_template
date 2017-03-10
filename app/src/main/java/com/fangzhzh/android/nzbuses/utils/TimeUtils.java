package com.fangzhzh.android.nzbuses.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author zhangzhenfang
 * @since 3/8/17 5:41 PM
 */
public class TimeUtils {
    public static int now() {
        long t = System.currentTimeMillis();
        return (int) (t / 1000);
    }

    public static String getFullFormatDate(int ts) {
        long nDate = 1000l * ts;
        SimpleDateFormat dateFormat =  new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.ENGLISH);
        return dateFormat.format(nDate);
    }
    public static String getFormatTime(int ts) {
        long nDate = 1000l * ts;
        SimpleDateFormat dateFormat =  new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        return dateFormat.format(nDate);
    }

}
