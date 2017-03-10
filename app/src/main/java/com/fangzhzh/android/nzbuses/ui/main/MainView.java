package com.fangzhzh.android.nzbuses.ui.main;


/**
 * @author zhangzhenfang
 * @since 1/18/17 2:03 PM
 */
public interface MainView {
    void startLoading();
    void stopLoading();
    void onError(int errCode, String errMsg);
    void onError(int errCode, int msgId);
    void onShowData(Object data);
}
