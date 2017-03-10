package com.fangzhzh.android.nzbuses.application;

import android.app.Application;
import android.content.Context;


import org.androidannotations.annotations.EApplication;

/**
 * @author zhangzhenfang
 * @since 17/10/16 9:40 PM
 */
@EApplication
public class WeatherApplication extends Application {
    public AppComponent appComponent;
    private static Application mInstance;

    public static Context getApplication() {
        return mInstance;
    }


    public static WeatherApplication get(Context context) {
        return (WeatherApplication) context.getApplicationContext();
    }


    public static WeatherApplication get() {
        return (WeatherApplication) mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
