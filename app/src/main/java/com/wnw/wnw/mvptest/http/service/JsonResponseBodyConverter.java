package com.wnw.wnw.mvptest.http.service;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.wnw.wnw.mvptest.MyApplication;
import com.wnw.wnw.mvptest.base.BaseListResult;
import com.wnw.wnw.mvptest.base.BaseResult;
import com.wnw.wnw.mvptest.exception.ApiException;

import java.io.IOException;
import java.io.StringReader;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 *
 * @author wnw
 *
 * @date 2017/10/25 0025 16:22
 *
 */
public class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson mGson;
    private final TypeAdapter<T> adapter;

    /**
     * 构造器
     */
    public JsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.mGson = gson;
        this.adapter = adapter;
    }

    /**
     * 转换
     *
     * @param value
     * @return
     * @throws IOException
     */
    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            String response = value.string();
            JsonReader jsonReader = new JsonReader(new StringReader(response));
            BaseResult result = mGson.fromJson(response, BaseResult.class);
            if (result == null) {
                BaseListResult listResult = mGson.fromJson(response, BaseListResult.class);
                if (!TextUtils.equals("ok", listResult.getState())) {
                    throw new ApiException(listResult.getState(), listResult.getError());
                }
            } else {
                if (!TextUtils.equals("ok", result.getState())) {
                    if (result.getCode().equals("0112")) {//token过期
                        MyApplication.getToken();
                    } else if (result.getCode().equals("0110")) {//登录超时
                        MyApplication.getToken();
                    } else {
                        throw new ApiException(result.getCode(), result.getError(), result.getState());
                    }
                }
            }

            return adapter.read(jsonReader);
        } finally {
            if (value != null){
                value.close();
            }
        }
    }

}
