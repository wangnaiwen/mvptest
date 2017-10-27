package com.wnw.wnw.mvptest.base;

import com.wnw.wnw.mvptest.http.service.HttpMethods;
import com.wnw.wnw.mvptest.mvp.IModel;

/**
 * Created by gaosheng on 2016/12/1.
 * 23:13
 * com.example.gs.mvpdemo.base
 */

public class BaseModel implements IModel {
    protected static HttpMethods httpMethods;

    //初始化httpService
    static {
        httpMethods = HttpMethods.getInstance();
    }

}
