package com.fangzhzh.android.nzbuses.utils;

import android.graphics.Paint;

/**
 * @author zhangzhenfang
 * @since 3/8/17 4:45 PM
 */
public class UiUtils {
    public static float getTextPaintOffset(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return -(fontMetrics.bottom - fontMetrics.top) / 2f - fontMetrics.top;
    }
}
