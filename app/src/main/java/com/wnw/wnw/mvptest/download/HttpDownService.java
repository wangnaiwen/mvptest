package com.wnw.wnw.mvptest.download;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * The interface Http down service.
 *
 * @author wnw
 * @date 2017 /10/26 0026 15:26
 */
public interface HttpDownService {

    /**
     * 断点续传下载接口
     * 大文件需要加入@Streaming判断，防止下载过程中写入到内存中
     * @param start the start
     * @param url   the url
     * @return the observable
     */

    @Streaming
    @GET
    Observable<ResponseBody> download(@Header("RANGE") String start, @Url String url);
}
