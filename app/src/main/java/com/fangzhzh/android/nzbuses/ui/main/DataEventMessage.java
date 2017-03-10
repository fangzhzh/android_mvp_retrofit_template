package com.fangzhzh.android.nzbuses.ui.main;

/**
 * @author zhangzhenfang
 * @since 3/8/17 2:08 PM
 */
class DataEventMessage {
    final Object data;
    final int errCode;
    final String errMsg;

    public DataEventMessage(Object data, int errCode,
        String errMsg) {
        this.data = data;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
