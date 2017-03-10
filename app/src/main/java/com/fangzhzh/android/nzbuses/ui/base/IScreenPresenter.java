package com.fangzhzh.android.nzbuses.ui.base;

/**
 * @author zhangzhenfang
 * @since 1/18/17 2:23 PM
 */
public abstract class IScreenPresenter<T> {
    protected T view;

    public void takeView(T view) {
        this.view = view;
        onInit();
    }

    protected void onShowView() {

    }

    protected void onInit() {

    }

    protected void onHideView() {

    }

    protected void onDestroy() {

    }

}
