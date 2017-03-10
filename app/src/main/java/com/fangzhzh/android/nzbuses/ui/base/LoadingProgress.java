package com.fangzhzh.android.nzbuses.ui.base;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.fangzhzh.android.nzbuses.utils.UILoop;
import javax.inject.Inject;

import com.android.sample.nzbuses.R;

/**
 * @author zhangzhenfang
 * @since 1/18/17 7:49 PM
 */

public class LoadingProgress {
    private final Activity activity;
    private UILoop uiLoop;
    private View mFrame;
    private boolean mHidden;
    private TextView textView;

    @Inject
    public LoadingProgress(Activity activity, UILoop uiLoop) {
        this.activity = activity;
        this.uiLoop = uiLoop;
    }

    public void show(final String text) {
        mHidden = false;
        uiLoop.delayPost(new Runnable() {
            @Override
            public void run() {
                if (!mHidden && !activity.isFinishing()) {
                    if (mFrame == null) {
                        mFrame = View.inflate(activity, R.layout.loading_layout, null);
                        FrameLayout rootView = (FrameLayout) activity.findViewById(android.R.id.content);
                        if (rootView != null) {
                            rootView.addView(mFrame, new FrameLayout.LayoutParams(
                                    FrameLayout.LayoutParams.MATCH_PARENT,
                                    FrameLayout.LayoutParams.MATCH_PARENT));
                        }
                    }
                    if (!TextUtils.isEmpty(text)) {
                        textView = (TextView) mFrame.findViewById(R.id.label);
                        textView.setText(text);
                    }
                    mFrame.setVisibility(View.VISIBLE);
                }
            }
        }, 400);}

    public void show() {
        show(null);
    }

    public void hide() {
        mHidden = true;
        if (mFrame != null) {
            mFrame.setVisibility(View.GONE);
        }
    }

}
