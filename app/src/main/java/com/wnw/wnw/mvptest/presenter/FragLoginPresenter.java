package com.wnw.wnw.mvptest.presenter;

import com.wnw.wnw.mvptest.base.BasePresenter;
import com.wnw.wnw.mvptest.bean.User;
import com.wnw.wnw.mvptest.bean.UserToken;
import com.wnw.wnw.mvptest.contract.LoginContract;
import com.wnw.wnw.mvptest.model.LoginModel;
import com.wnw.wnw.mvptest.model.TokenModel;
import com.wnw.wnw.mvptest.mvp.IModel;
import com.wnw.wnw.mvptest.view.fragment.TestFragment;

import java.util.HashMap;

/**
 * @author wnw
 * @date 2017/10/26 0026 10:11
 */
public class FragLoginPresenter extends BasePresenter<TestFragment> implements
        LoginContract.LoginPresenter {

    @Override
    public void login(String name, String pwd) {
        if (!getIView().checkNull()) {
            ((LoginModel) getModelMap().get("login")).login(name, pwd, new LoginModel.LoginListener() {
                @Override
                public void successInfo(User user) {
                    getIView().loginSuccess(user);
                }

                @Override
                public void failInfo(String str) {
                    getIView().loginFail(str);
                }
            });
        }
    }

    @Override
    public void getToken(String userName, String userId) {
        ((TokenModel)getModelMap().get("getToken")).getUserToken(userName, userId, new TokenModel.GetTokenListener() {
            @Override
            public void successInfo(UserToken token) {
                getIView().getTokenSuccess(token);
            }

            @Override
            public void failInfo(String str) {
                getIView().getTokenFail(str);
            }
        });
    }

    @Override
    public HashMap<String, IModel> getModelMap() {
        return loadModelMap(new LoginModel(), new TokenModel());
    }

    @Override
    public HashMap<String, IModel> loadModelMap(IModel... models) {
        HashMap<String, IModel> map = new HashMap<>();
        map.put("login", models[0]);
        map.put("getToken", models[1]);
        return map;
    }
}


