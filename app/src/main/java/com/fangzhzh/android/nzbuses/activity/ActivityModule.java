package com.fangzhzh.android.nzbuses.activity;

import android.app.Activity;
import android.content.Context;

import com.fangzhzh.android.nzbuses.ui.base.BaseActivity;
import com.fangzhzh.android.nzbuses.ui.base.Scope;
import com.fangzhzh.android.nzbuses.utils.Navigator;
import com.fangzhzh.android.nzbuses.utils.UILoop;
import dagger.Module;
import dagger.Provides;

/**
 * @author zhangzhenfang
 * @since 1/18/17 4:33 AM
 */
@Module
public class ActivityModule {
    private BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return activity;
    }

    @ActivityScope
    @Provides
    Context provideContext() {
        return activity;
    }


    @ActivityScope
    @Provides
    Scope provideScope() {
        return activity;
    }

    @Provides
    @ActivityScope UILoop provideUILoop() {
        return new UILoop();
    }

    @ActivityScope
    @Provides
    Navigator provideNavigator() {
        return new Navigator(activity);
    }

}
