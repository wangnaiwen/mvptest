package com.wnw.wnw.mvptest.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wnw.wnw.mvptest.mvp.IView;

/**
 * The type Base fragment.
 *
 * @param <P> the type parameter
 * @author wnw
 * @date 2017 /10/26 0026 9:26
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IView{

    private Context context;

    private View view;

    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.context = inflater.getContext();
        getView();
        initView(view);
        mPresenter = loadPresenter();
        initCommonData();
        initData();
        return view;
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
     *
     * @param view the view
     */
    protected abstract void initView(View view);

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
    @Nullable
    @Override
    public View getView() {
        view = View.inflate(context, getLayoutId(), null);
        return view;
    }
}
