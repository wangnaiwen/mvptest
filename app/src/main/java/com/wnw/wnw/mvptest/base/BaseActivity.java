package com.wnw.wnw.mvptest.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.wnw.wnw.mvptest.mvp.IView;

/**
 * The type Base activity.
 *
 * @param <P> the type parameter
 * @author wnw
 * @date 2017 /10/25 0025 16:56
 */
public abstract class BaseActivity<P extends BasePresenter> extends FragmentActivity implements
        IView{
    /**
     * The View.
     */
    protected View view;

    /**
     * The M presenter.
     */
    protected P mPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        initView();
        mPresenter = loadPresenter();
        initCommonData();
        initData();
    }

    /**
     * Load presenter p.
     *
     * @return the p
     */
    protected abstract P loadPresenter();

    private void initCommonData() {
        if (mPresenter != null){
            mPresenter.attachView(this);
        }
    }

    /**
     * Init data.
     */
    protected abstract void initData();

    /**
     * Init view.
     */
    protected abstract void initView();

    /**
     * Gets layout id.
     *
     * @return the layout id
     */
    protected abstract int getLayoutId();

    /**
     * Gets view.
     *
     * @return 显示的内容 view
     */
    public View getView() {
        view = View.inflate(this, getLayoutId(), null);
        return view;
    }

}

