package com.wnw.wnw.mvptest.view.fragment;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wnw.wnw.mvptest.R;
import com.wnw.wnw.mvptest.base.BaseFragment;
import com.wnw.wnw.mvptest.bean.User;
import com.wnw.wnw.mvptest.bean.UserToken;
import com.wnw.wnw.mvptest.contract.LoginContract;
import com.wnw.wnw.mvptest.http.service.HttpMethods;
import com.wnw.wnw.mvptest.presenter.FragLoginPresenter;
import com.wnw.wnw.mvptest.util.CommonUtil;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * @author wnw
 * @date 2017/10/26 0026 9:34
 */
public class TestFragment extends BaseFragment<FragLoginPresenter> implements LoginContract.LoginView{
    @BindView(R.id.input_email)
    EditText inputEmail;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    public String getUserName() {
        return inputEmail.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return inputPassword.getText().toString().trim();
    }


    @Override
    public void loginSuccess(User user) {
        CommonUtil.printLogs("wnw", "login success");
        mPresenter.getToken(user.getUsername(), user.getId());
    }

    @Override
    public void loginFail(String failMsg) {
        CommonUtil.printLogs("wnw", "login fail");
    }

    @Override
    public void getTokenSuccess(UserToken userToken) {
        CommonUtil.printLogs("wnw", "token success");
    }

    @Override
    protected FragLoginPresenter loadPresenter() {
        return new FragLoginPresenter();
    }

    @Override
    public void getTokenFail(String failMsg) {
        CommonUtil.printLogs("wnw", "token fail");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public boolean checkNull() {
        boolean isNull = false;
        if (TextUtils.isEmpty(getUserName())) {
            inputEmail.setError("账号不能为空");
            isNull = true;
        } else if (TextUtils.isEmpty(getPwd())) {
            inputPassword.setError("密码不能为空");
            isNull = true;
        }
        return isNull;
    }

    @OnClick(R.id.btn_login)
    void login(){
        mPresenter.login(getUserName(), getPwd());
    }
}
