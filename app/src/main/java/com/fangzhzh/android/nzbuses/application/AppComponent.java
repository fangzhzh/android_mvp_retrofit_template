package com.fangzhzh.android.nzbuses.application;

import com.fangzhzh.android.nzbuses.activity.ActivityComponent;
import javax.inject.Singleton;

import com.fangzhzh.android.nzbuses.activity.ActivityModule;
import dagger.Component;

/**
 * @author zhangzhenfang
 * @since 1/18/17 4:33 AM
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
        }
)
public interface AppComponent {
    ActivityComponent plus(ActivityModule activityModule);
}
