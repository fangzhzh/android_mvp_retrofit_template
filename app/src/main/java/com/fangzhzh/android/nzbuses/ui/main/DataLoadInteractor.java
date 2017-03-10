package com.fangzhzh.android.nzbuses.ui.main;

import com.fangzhzh.android.nzbuses.api.MainAPIService;
import com.fangzhzh.android.nzbuses.ui.base.BaseInteractor;
import dagger.Lazy;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author zhangzhenfang
 * @since 3/8/17 1:59 PM
 */
class DataLoadInteractor extends BaseInteractor<DataLoadInteractor.MainData> {

    private Lazy<MainAPIService> weatherAPIServiceLazy;

    @Inject
    public DataLoadInteractor(Lazy<MainAPIService> weatherAPIServiceLazy) {
        this.weatherAPIServiceLazy = weatherAPIServiceLazy;
    }

    @Override protected void onExecute(MainData data) {
        Call<Object> dataCall = weatherAPIServiceLazy.get().getData("test");
        dataCall.enqueue(new Callback<Object>() {
            @Override public void onResponse(Call<Object> call, Response<Object> response) {
                Object data = null;

                int errCode = 0;
                String errMsg = null;

                if (response.isSuccessful()) {
                    data = response.body();
                } else {
                    errCode = response.code();
                    errMsg = response.errorBody().toString();
                }
                EventBus.getDefault().post(new DataEventMessage(data, errCode, errMsg));

            }

            @Override public void onFailure(Call<Object> call, Throwable t) {
                EventBus.getDefault().post(new DataEventMessage(null, -1, null));
            }
        });
    }

    public void initData() {
        onExecute(null);

    }

    public static class MainData extends BaseInteractor.Data {

        public MainData() {
            super("DataLoadInteractor", "DataLoadInteractor");
        }
    }
}
