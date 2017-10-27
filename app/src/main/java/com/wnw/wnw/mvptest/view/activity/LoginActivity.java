package com.wnw.wnw.mvptest.view.activity;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.wnw.wnw.mvptest.R;
import com.wnw.wnw.mvptest.base.BaseActivity;
import com.wnw.wnw.mvptest.bean.User;
import com.wnw.wnw.mvptest.bean.UserToken;
import com.wnw.wnw.mvptest.contract.LoginContract;
import com.wnw.wnw.mvptest.presenter.LoginPresenter;
import com.wnw.wnw.mvptest.util.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * @author wnw
 *
 * @date 2017/10/25 0025 17:04
 *
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView {

    @BindView(R.id.input_email)
    EditText inputEmail;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected LoginPresenter loadPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

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
        if (user != null){
            CommonUtil.printLogs("wnw","登录成功");
            mPresenter.getToken(user.getName(), user.getId());
        }
    }

    @Override
    public void loginFail(String failMsg) {
        CommonUtil.printLogs("wnw","登录失败");
    }

    @Override
    public void getTokenSuccess(UserToken userToken) {
        CommonUtil.printLogs("wnw","获取Token成功");
    }

    @Override
    public void getTokenFail(String failMsg) {
        CommonUtil.printLogs("wnw","获取Token成功");
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
