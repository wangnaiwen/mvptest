package com.wnw.wnw.mvptest.http.service;

import com.wnw.wnw.mvptest.base.BaseResult;
import com.wnw.wnw.mvptest.bean.User;
import com.wnw.wnw.mvptest.bean.UserToken;

import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 *
 * @author wnw
 *
 * @date 2017/10/25 0025 15:48
 *
 */

public interface HttpService {

    @FormUrlEncoded
    @POST("login")
    Observable<BaseResult<User>> login(@Field("action") String action, @Field("username") String username, @Field("passwd") String passwd, @Field("role_flag") String role_flag);

    /**
     * 获取token
     */
    @GET("usertoken")
    Observable<BaseResult<UserToken>> getToken(@Query("action") String action, @Query("user_name") String user_name, @Query("user_id") String user_id);

}
