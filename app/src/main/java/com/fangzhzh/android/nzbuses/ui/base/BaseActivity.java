package com.fangzhzh.android.nzbuses.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import com.fangzhzh.android.nzbuses.utils.ListUtils;

/**
 * @author zhangzhenfang
 * @since 1/18/17 4:33 AM
 */
public abstract class BaseActivity extends AppCompatActivity implements Scope{

    List<IScreenPresenter> presenterList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivity();
    }
    private void initActivity() {
        setupActivityComponent();
        presenterList = new ArrayList<>();
    }

    @Override
    public void attach(IScreenPresenter presenter) {
        if (!ListUtils.isEmpty(presenterList)) {
            presenterList.add(presenter);
        }
    }

    @Override
    public void detach(IScreenPresenter presenter) {
        if (!ListUtils.isEmpty(presenterList)) {
            presenterList.remove(presenter);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (IScreenPresenter presenter : presenterList) {
            presenter.onShowView();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        for (IScreenPresenter presenter : presenterList) {
            presenter.onHideView();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (IScreenPresenter presenter : presenterList) {
            presenter.onDestroy();
        }
    }

    protected abstract void setupActivityComponent();
}
