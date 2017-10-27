package com.wnw.wnw.mvptest.download;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * The type Download response body.
 *
 * @author wnw
 * @date 2017 /10/26 0026 15:06
 */
public class DownloadResponseBody extends ResponseBody {

    private ResponseBody responseBody;
    private DownloadProgressListener progressListener;
    private BufferedSource bufferedSource;

    /**
     * Instantiates a new Download response body.
     *
     * @param responseBody             the response body
     * @param downloadProgressListener the download progress listener
     */
    public DownloadResponseBody(ResponseBody responseBody, DownloadProgressListener downloadProgressListener){
        this.responseBody = responseBody;
        this.progressListener = downloadProgressListener;
    }

    @Override
    public MediaType contentType() {
        return responseBody.contentType();
    }

    @Override
    public long contentLength() {
        return responseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if (bufferedSource == null){
            bufferedSource = Okio.buffer(source(responseBody.source()));
        }
        return bufferedSource;
    }

    /**
     * 在这里去获得总的长度和已经读取的长度，并且利用回调接口更新Progress
     * */
    private Source source(Source source){
        return new ForwardingSource(source) {
            long totalBytesRead = 0L;

            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                if (null != progressListener) {
                    progressListener.update(totalBytesRead, responseBody.contentLength(), bytesRead == -1);
                }
                return bytesRead;
            }
        };

    }
}
