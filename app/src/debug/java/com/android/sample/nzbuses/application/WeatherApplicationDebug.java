package com.android.sample.nzbuses.application;


import com.facebook.stetho.Stetho;
import com.fangzhzh.android.nzbuses.application.WeatherApplication;
import com.frogermcs.androiddevmetrics.AndroidDevMetrics;

import org.androidannotations.annotations.EApplication;

/**
 * @author zhangzhenfang
 * @since 1/19/17 1:45 PM
 */
@EApplication
public class WeatherApplicationDebug extends WeatherApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        setupDebugEnvironment();
    }

    private void setupDebugEnvironment() {
        AndroidDevMetrics.initWith(this);
        Stetho.initializeWithDefaults(this);
    }

}
