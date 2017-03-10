package com.fangzhzh.android.nzbuses.ui.base;

import android.util.Log;

import com.fangzhzh.android.nzbuses.utils.CONST;
import org.androidannotations.api.BackgroundExecutor;

/**
 * @author zhangzhenfang
 * @since 1/18/17 3:40 PM
 */
public abstract class BaseInteractor<T extends BaseInteractor.Data> {

    public final void execute(final T data) {
        final BackgroundExecutor.Task task = new BackgroundExecutor.Task(data.id,
                0,
                data.serialId) {
            @Override
            public void execute() {
                BaseInteractor.this.run(data);
            }
        };

        BackgroundExecutor.execute(task);


    }

    private void run(T data) {
        try {
            onExecute(data);
        } catch (Exception e) {
            Log.e(CONST.LOG_TAG, e.toString());
        }
    }

    protected abstract void onExecute(T data);

    public static class Data {
        public String id;
        public String serialId;

        public Data(String id, String serialIdh) {
            this.id = id;
            this.serialId = serialId;
        }
    }
}
