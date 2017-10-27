package com.wnw.wnw.mvptest.download;

/**
 * The interface Download progress listener.
 *
 * @author wnw
 * @date 2017 /10/26 0026 15:01
 */
public interface DownloadProgressListener {

    /**
     * Update.
     *
     * @param read  the read
     * @param total the total
     * @param done  the done
     */
    void update(long read, long total, boolean done);
}
