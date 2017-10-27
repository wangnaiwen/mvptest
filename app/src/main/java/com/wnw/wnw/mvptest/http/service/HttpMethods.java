package com.wnw.wnw.mvptest.http.service;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.wnw.wnw.mvptest.base.BaseListResult;
import com.wnw.wnw.mvptest.base.BaseResult;
import com.wnw.wnw.mvptest.bean.User;
import com.wnw.wnw.mvptest.bean.UserToken;
import com.wnw.wnw.mvptest.exception.ApiException;
import com.wnw.wnw.mvptest.util.Base64Utils;
import com.wnw.wnw.mvptest.util.CommonUtil;
import com.wnw.wnw.mvptest.util.Constants;
import com.wnw.wnw.mvptest.util.RSAUtil;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author wnw
 * @date 2017/10/25 0025 15:55
 */
public class HttpMethods {

    public static final String BASE_URL = "http://api.xiubike.com/";
    private static final int DEFAULT_TIMEOUT = 10;

    private Retrofit retrofit;
    private HttpService apiService;
    private PublicKey mPublicKey;

    private HttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .addConverterFactory(JsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        apiService = retrofit.create(HttpService.class);
        try {
            if (mPublicKey == null){
                mPublicKey = RSAUtil.loadPublicKey(Constants.RSA_PUBLIC_KEY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private OkHttpClient getOkHttpClient() {
        //日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {

            }
        });
        loggingInterceptor.setLevel(level);
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        //OkHttp进行添加拦截器loggingInterceptor
        httpClientBuilder.addInterceptor(loggingInterceptor);
        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                RequestBody body = request.body();
                Buffer buffer = new Buffer();
                Request.Builder requestBuilder = request.newBuilder();

                if (request.method().equals("GET")) {

                } else {
                    try {
                        body.writeTo(buffer);
                        String paramStr = new String(buffer.readByteString().toByteArray());
                        if (!TextUtils.isEmpty(paramStr)) {
                            CommonUtil.printLogs(HttpMethods.class.getName(), "POST Interceptor before:" + paramStr);
                            byte[] encryptByte = RSAUtil.encryptData(paramStr.getBytes(), mPublicKey);
                            String param = "sign=" + URLEncoder.encode(Base64Utils.encode(encryptByte), "UTF-8");
                            CommonUtil.printLogs(HttpMethods.class.getName(), "POST Interceptor RSAUtil encrypt  param:" + URLEncoder.encode(param, "UTF-8"));

                            if (request.method().equals("PUT")) {
                                requestBuilder.put(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"), param));
                            } else {
                                requestBuilder.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"), param));
                            }

                            return chain.proceed(requestBuilder.build());
                        }
                    } catch (Exception e) {
                        CommonUtil.printLogs(HttpMethods.class.getName(), e.getMessage());
                    }
                }

                return chain.proceed(request);
            }
        });

        return httpClientBuilder.build();
    }

    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public HttpService getApiService() {
        return apiService;
    }

    /**
     * 线程切换
     *
     * @param o
     * @param s
     * @param <T>
     */
    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<BaseResult<T>, T> {

        @Override
        public T call(BaseResult<T> baseResult) {

            if (!TextUtils.equals("ok", baseResult.getState())) {
                throw new ApiException(baseResult.getState(), baseResult.getError());
            }

            return baseResult.getData();

        }
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的list部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpListResultFunc<T> implements Func1<BaseListResult<T>, List<T>> {

        @Override
        public List<T> call(BaseListResult<T> baseResult) {

            if (!TextUtils.equals("ok", baseResult.getState())) {
                throw new ApiException(baseResult.getState(), baseResult.getError());
            }

            return baseResult.getList();

        }
    }

    public void login(String username, String passwd, Subscriber<User> subscriber) {
        Observable<User> observable = apiService.login("actionUserLogin", username, passwd, "3").map(new HttpResultFunc<User>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 获取token
     *
     * @param user_name 手机号
     * @param user_id   userId
     */
    public void getToken(String user_name, String user_id, Subscriber<UserToken> subscriber) {
        Observable<UserToken> observable = apiService.getToken("actionGetUserToken", user_name, user_id).map(new HttpResultFunc<UserToken>());
        toSubscribe(observable, subscriber);
    }

}
