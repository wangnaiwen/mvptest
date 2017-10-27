package com.wnw.wnw.mvptest.base;

import com.wnw.wnw.mvptest.mvp.IModel;
import com.wnw.wnw.mvptest.mvp.IPresenter;
import com.wnw.wnw.mvptest.mvp.IView;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * The type Base presenter.
 *
 * @param <V> the type parameter
 * @author wnw
 * @date 2017 /10/25 0025 16:38
 */
public abstract class BasePresenter<V extends IView> implements IPresenter {
    private WeakReference actReference;

    /**
     * Gets model map.
     *
     * @return the model map
     */
    public abstract HashMap<String, IModel> getModelMap();

    @Override
    public void attachView(IView iView) {
        actReference = new WeakReference(iView);
    }

    @Override
    public void detachView() {
        if (actReference != null) {
            actReference.clear();
            actReference = null;
        }
    }

    @Override
    public V getIView() {
        return (V) actReference.get();
    }

    /**
     * Load model map hash map.
     *
     * @param models the models
     * @return the hash map
     */
    public abstract HashMap<String, IModel> loadModelMap(IModel... models);

}
