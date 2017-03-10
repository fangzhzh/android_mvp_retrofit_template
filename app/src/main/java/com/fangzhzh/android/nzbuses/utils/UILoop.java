package com.fangzhzh.android.nzbuses.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * @author zhangzhenfang
 * @since 1/18/17 8:03 PM
 */
public class UILoop {
    public UILoop() {
        m_uiHandler  = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                Runnable info = (Runnable) msg.obj;
                if (info != null) {
                    info.run();
                } else {
                    Log.e(CONST.LOG_TAG,"UI callback is null");
                }
            }
        };
    }

    private Handler m_uiHandler;

    public void init() {
        Log.i(CONST.LOG_TAG, "UILoop init");
    }

    public void post(Runnable call) {
        m_uiHandler.post(call);
    }

    public void delayPost(Runnable r, int delayMillis) {
        m_uiHandler.postDelayed(r, delayMillis);
    }

    public void cancelPost(Runnable r) {
        m_uiHandler.removeCallbacks(r);
    }
}
