package com.fangzhzh.android.nzbuses.ui.main;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.android.sample.nzbuses.R;
import com.fangzhzh.android.nzbuses.ui.base.IScreenPresenter;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author zhangzhenfang
 * @since 1/18/17 2:03 PM
 */
@DebugLog
public class MainPresenter extends IScreenPresenter<MainView> {

    private DataLoadInteractor dataLoadInteractor;

    @Inject
    public MainPresenter(DataLoadInteractor dataLoadInteractor) {
        this.dataLoadInteractor =dataLoadInteractor;
    }

    @Override
    protected void onInit() {
        super.onInit();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    private void loadFromServer() {
        dataLoadInteractor.initData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onWeatherOverViewLoaded(DataEventMessage eventMessage) {
        if (eventMessage == null
                ||
                (eventMessage.errCode == 0
                        && TextUtils.isEmpty(eventMessage.errMsg)
                        && eventMessage.data == null)) {
            return;
        }
        if (eventMessage.errCode != 0 || !TextUtils.isEmpty(eventMessage.errMsg)) {

            // first time,
            if (eventMessage.errCode == -1) {
                view.stopLoading();
                view.onError(eventMessage.errCode,
                        R.string.ct_bad_network);
            } else {
                view.stopLoading();
                view.onError(eventMessage.errCode, eventMessage.errMsg);
            }
        } else {
            loadWeatherOverview(eventMessage.data);
        }
    }

    private void loadWeatherOverview(@NonNull Object data) {
        view.stopLoading();
        view.onShowData(data);

    }


    public void initData() {
        view.startLoading();
        loadFromServer();
    }
}
