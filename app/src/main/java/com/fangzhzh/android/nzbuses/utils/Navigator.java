package com.fangzhzh.android.nzbuses.utils;

import android.app.Activity;
import android.content.Context;

import javax.inject.Inject;


/**
 * @author zhangzhenfang
 * @since 1/19/17 3:16 PM
 */
public class Navigator {
    private Activity activity;

    @Inject
    public Navigator(Activity activity) {
        this.activity = activity;
    }

    public Context getContext() {
        return this.activity;
    }

}
