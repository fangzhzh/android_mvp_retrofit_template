package com.fangzhzh.android.nzbuses.utils;

import android.content.Context;
import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;

/**
 * @author zhangzhenfang
 * @since 3/9/17 1:27 PM
 */
public class PopUpDialogHelper {
    public static void showListDialog(Context context, String title, CharSequence[] charSequences, final IListDialogCallback listDialogCallback) {
        MaterialDialog dialog = new MaterialDialog.Builder(context)
            .title(title)
            .items(charSequences)
            .itemsCallback(new MaterialDialog.ListCallback() {
                @Override
                public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                    listDialogCallback.onSelection(dialog, view, which, text);
                }
            })
            .show();
    }

    public interface IListDialogCallback {
        void onSelection(MaterialDialog dialog, View view, int which, CharSequence text);
    }
}
