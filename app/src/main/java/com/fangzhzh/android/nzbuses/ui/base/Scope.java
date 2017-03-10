package com.fangzhzh.android.nzbuses.ui.base;

/**
 * @author zhangzhenfang
 * @since 1/18/17 2:28 PM
 */
public interface Scope {
    void attach(IScreenPresenter presenter);

    void detach(IScreenPresenter presenter);
}
