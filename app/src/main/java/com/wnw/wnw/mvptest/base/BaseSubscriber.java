package com.wnw.wnw.mvptest.base;

import com.wnw.wnw.mvptest.exception.ApiException;

import rx.Subscriber;

/**
 * @author wnw
 * @date 2017/10/25 0025 16:04
 */
public abstract class BaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onError(Throwable e) {
        ApiException apiException = (ApiException) e;
        onError(apiException);
    }

    /**
     * @param e 错误的一个回调
     */
    protected abstract void onError(ApiException e);
}
