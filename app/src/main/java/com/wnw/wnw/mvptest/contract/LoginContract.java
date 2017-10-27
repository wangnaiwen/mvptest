package com.wnw.wnw.mvptest.contract;

import com.wnw.wnw.mvptest.bean.User;
import com.wnw.wnw.mvptest.bean.UserToken;

/**
 * The type Login contract.
 *
 * @author wnw
 * @date 2017 /10/25 0025 16:40
 */
public class LoginContract {
    /**
     * The interface Login view.
     */
    public interface LoginView {
        /**
         * Gets user name.
         *
         * @return the user name
         */
        String getUserName();

        /**
         * Gets pwd.
         *
         * @return the pwd
         */
        String getPwd();

        /**
         * Login success.
         *
         * @param user the user
         */
        void loginSuccess(User user);

        /**
         * Login fail.
         *
         * @param failMsg the fail msg
         */
        void loginFail(String failMsg);


        /**
         * Gets token success.
         *
         * @param userToken the user token
         */
        void getTokenSuccess(UserToken userToken);

        /**
         * Gets token fail.
         *
         * @param failMsg the fail msg
         */
        void getTokenFail(String failMsg);
    }


    /**
     * The interface Login presenter.
     */
    public interface LoginPresenter {
        /**
         * Login.
         *
         * @param name the name
         * @param pwd  the pwd
         */
        void login(String name, String pwd);

        /**
         * Gets token.
         *
         * @param userName the user name
         * @param userId   the user id
         */
        void getToken(String userName, String userId);
    }
}
