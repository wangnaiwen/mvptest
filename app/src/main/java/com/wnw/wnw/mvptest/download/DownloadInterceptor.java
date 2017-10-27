package com.wnw.wnw.mvptest.download;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * The type Download interceptor.
 *
 * @author wnw
 * @date 2017 /10/26 0026 15:02
 */
public class DownloadInterceptor implements Interceptor {

    private DownloadProgressListener listener;

    /**
     * Instantiates a new Download interceptor.
     *
     * @param listener the listener
     */
    public DownloadInterceptor(DownloadProgressListener listener) {
        this.listener = listener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response.newBuilder().body(new DownloadResponseBody(response.body(), listener)).build();
    }
}
