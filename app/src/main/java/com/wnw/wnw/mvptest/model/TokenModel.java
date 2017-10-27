package com.wnw.wnw.mvptest.model;

import android.support.annotation.NonNull;

import com.wnw.wnw.mvptest.MyApplication;
import com.wnw.wnw.mvptest.base.BaseModel;
import com.wnw.wnw.mvptest.bean.UserToken;
import com.wnw.wnw.mvptest.exception.ApiException;
import com.wnw.wnw.mvptest.http.service.HttpMethods;
import com.wnw.wnw.mvptest.http.subscriber.CommonSubscriber;

/**
 * @author wnw
 * @date 2017/10/25 0025 18:20
 */
public class TokenModel extends BaseModel {

    public void getUserToken(@NonNull String userName, @NonNull String userId, @NonNull final GetTokenListener getTokenListener){
        HttpMethods.getInstance().getToken(userName, userId, new CommonSubscriber<UserToken>(MyApplication.getmContext()) {
            @Override
            public void onNext(UserToken token) {
                getTokenListener.successInfo(token);
            }

            @Override
            protected void onError(ApiException e) {
                getTokenListener.failInfo(e.getMessage());
            }
        });
    }


    public interface GetTokenListener {

        void successInfo(UserToken token);

        void failInfo(String str);

    }
}