package com.fangzhzh.android.nzbuses.ui.main;

import android.os.Bundle;

import com.fangzhzh.android.nzbuses.utils.SnackbarUtils;
import com.fangzhzh.android.nzbuses.activity.ActivityModule;
import com.fangzhzh.android.nzbuses.application.WeatherApplication;
import com.fangzhzh.android.nzbuses.ui.base.BaseActivity;
import com.fangzhzh.android.nzbuses.ui.base.LoadingProgress;
import com.fangzhzh.android.nzbuses.ui.base.Scope;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

import com.android.sample.nzbuses.R;

/**
 * @author zhangzhenfang
 * @since 1/18/17 4:33 AM
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity implements MainView {
    @Inject LoadingProgress progressBar;
    @Inject Scope scope;

    @Inject MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setupActivityComponent() {
        WeatherApplication.get().getAppComponent().plus(new ActivityModule(this)).inject(this);
    }

    @AfterViews
    void onViewInit() {
        scope.attach(presenter);
        presenter.takeView(this);
        presenter.initData();

    }


    @Override
    public void startLoading() {
        progressBar.show();
    }

    @Override public void stopLoading() {
        progressBar.hide();
    }

    @Override public void onError(int errCode, String errMsg) {
        SnackbarUtils.showSnackbar(this, getResources().getString(R.string.loading_error_message, errCode, errMsg));
    }

    @Override public void onError(int errCode, int msgId) {
        onError(errCode, getResources().getString(msgId));
    }

    @Override public void onShowData(Object data) {

    }

    @Override protected void onResume() {
        super.onResume();
    }

    @Override protected void onPause() {
        super.onPause();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
    }
}
