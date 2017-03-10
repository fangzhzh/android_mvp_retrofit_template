package com.fangzhzh.android.nzbuses.utils;

import android.util.Log;

/**
 * @author zhangzhenfang
 * @since 1/19/17 6:57 PM
 */
public class AppLogger {
    public static void e(Exception e) {
        Log.e(CONST.LOG_TAG, e.toString());
    }
    public static void d(String msg) {
        Log.e(CONST.LOG_TAG, msg);
    }
}
