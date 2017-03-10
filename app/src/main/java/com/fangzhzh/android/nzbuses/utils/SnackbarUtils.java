package com.fangzhzh.android.nzbuses.utils;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.sample.nzbuses.R;

/**
 * @author zhangzhenfang
 * @since 1/19/17 11:24 AM
 */
public class SnackbarUtils {
    /**
     *
     * @param activity which needs to show snackbar
     * @param msg msg need to show
     */

    public static void showSnackbar(Activity activity, String msg) {
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) activity
                .findViewById(android.R.id.content)).getChildAt(0);
        showSnackbar(viewGroup, msg, Snackbar.LENGTH_LONG);
    }

    private static void showSnackbar(View view, String msg, int length) {
        if (view.isShown()) {
            Snackbar snackbar = Snackbar.make(view, msg, length);
            View snackbarView = snackbar.getView();
            TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(view.getResources().getColor(R.color.white));
            textView.setMaxLines(5);
            snackbar.show();
        }
    }
}
