package com.wnw.wnw.mvptest.model;

import android.support.annotation.NonNull;

import com.wnw.wnw.mvptest.MyApplication;
import com.wnw.wnw.mvptest.base.BaseModel;
import com.wnw.wnw.mvptest.bean.User;
import com.wnw.wnw.mvptest.exception.ApiException;
import com.wnw.wnw.mvptest.http.subscriber.CommonSubscriber;

/**
 * The type Login model.
 *
 * @author wnw
 * @date 2017 /10/25 0025 16:41
 */
public class LoginModel extends BaseModel {
    private boolean isLogin = false;

    /**
     * Login boolean.
     *
     * @param username      the username
     * @param pwd           the pwd
     * @param loginListener the login listener
     * @return the boolean
     */
    public boolean login(@NonNull String username, @NonNull String pwd, @NonNull final LoginListener
            loginListener) {

        httpMethods.login(username, pwd, new CommonSubscriber<User>(MyApplication.getmContext()) {
            @Override
            public void onNext(User user) {
                isLogin = true;
                loginListener.successInfo(user);
            }

            @Override
            protected void onError(ApiException e) {
                super.onError(e);
                isLogin = false;
                loginListener.failInfo(e.message);
            }
        });
        return isLogin;
    }


    /**
     * The interface Login listener.
     */
    public interface LoginListener {

        /**
         * Success info.
         *
         * @param user the user
         */
        void successInfo(User user);

        /**
         * Fail info.
         *
         * @param str the str
         */
        void failInfo(String str);

    }

}

