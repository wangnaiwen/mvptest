package com.wnw.wnw.mvptest;

import android.app.Application;
import android.content.Context;

import com.wnw.wnw.mvptest.bean.User;
import com.wnw.wnw.mvptest.bean.UserToken;
import com.wnw.wnw.mvptest.download.RxRetrofitApp;
import com.wnw.wnw.mvptest.exception.ApiException;
import com.wnw.wnw.mvptest.http.service.HttpMethods;
import com.wnw.wnw.mvptest.http.subscriber.CommonSubscriber;
import com.wnw.wnw.mvptest.util.MySharedPreferences;

/**
 * @author wnw
 * @date 2017/10/25 0025 16:48
 */
public class MyApplication extends Application{
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        RxRetrofitApp.init(this);
    }

    /**
     * @return
     * 全局的上下文
     */
    public static Context getmContext() {
        return mContext;
    }

    public static void getToken() {
        User user = MySharedPreferences.getInstance(mContext).getUser();
        if (user == null){
            return;
        }

        HttpMethods.getInstance().getToken(user.getUsername(), user.getId(), new CommonSubscriber<UserToken>(mContext) {
            @Override
            public void onNext(UserToken userToken) {
                MySharedPreferences.getInstance(mContext).saveToken(userToken.getToken());
            }

            @Override
            protected void onError(ApiException e) {

            }
        });
    }

}
