package com.fangzhzh.android.nzbuses.activity;

import com.fangzhzh.android.nzbuses.ui.main.MainActivity;
import com.fangzhzh.android.nzbuses.ui.main.MainView;
import dagger.Subcomponent;

/**
 * @author zhangzhenfang
 * @since 1/18/17 4:33 AM
 */


@ActivityScope
@Subcomponent(
        modules = ActivityModule.class
)

public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(MainView view);
}
