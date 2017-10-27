package com.wnw.wnw.mvptest.http.subscriber;

import android.content.Context;

import com.wnw.wnw.mvptest.base.BaseSubscriber;
import com.wnw.wnw.mvptest.exception.ApiException;
import com.wnw.wnw.mvptest.util.CommonUtil;
import com.wnw.wnw.mvptest.util.NetworkUtil;

/**
 * The type Common subscriber.
 *
 * @param <T> the type parameter
 * @author wnw
 * @date 2017 /10/25 0025 16:32
 */
public abstract class CommonSubscriber<T> extends BaseSubscriber<T> {

    private Context context;

    /**
     * Instantiates a new Common subscriber.
     *
     * @param context the context
     */
    public CommonSubscriber(Context context) {
        this.context = context;
    }

    private static final String TAG = "CommonSubscriber";

    @Override
    public void onStart() {

        if (!NetworkUtil.isNetworkAvailable(context)) {
            CommonUtil.printLogs(TAG, "网络不可用");
        } else {
            CommonUtil.printLogs(TAG, "网络可用");
        }
    }

    @Override
    protected void onError(ApiException e) {
        CommonUtil.printLogs(TAG, "错误信息为 " + "code:" + e.code + "   message:" + e.message);
    }

    @Override
    public void onCompleted() {
        CommonUtil.printLogs(TAG, "成功了");
    }

}
