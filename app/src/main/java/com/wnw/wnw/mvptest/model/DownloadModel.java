package com.wnw.wnw.mvptest.model;

import com.wnw.wnw.mvptest.base.BaseModel;
import com.wnw.wnw.mvptest.download.DownInfo;
import com.wnw.wnw.mvptest.download.HttpDownManager;

/**
 * The type Download model.
 *
 * @author wnw
 * @date 2017 /10/27 0027 9:20
 */
public class DownloadModel extends BaseModel{

    /**
     * Download.
     *
     * @param downInfo the down info
     */
    public void download(DownInfo downInfo){
        HttpDownManager.getInstance().startDown(downInfo);
    }

    /**
     * Pause download.
     *
     * @param downInfo the down info
     */
    public void pauseDownload(DownInfo downInfo){
        HttpDownManager.getInstance().pause(downInfo);
    }

    /**
     * Stop download.
     *
     * @param downInfo the down info
     */
    public void stopDownload(DownInfo downInfo){
        HttpDownManager.getInstance().stopDown(downInfo);
    }

    /**
     * Stop all download.
     */
    public void stopAllDownload(){
        HttpDownManager.getInstance().stopAllDown();
    }

    /**
     * Pausell download.
     */
    public void pausellDownload(){
        HttpDownManager.getInstance().pauseAll();
    }

    /**
     * Get all download.
     */
    public void getAllDownload(){
        HttpDownManager.getInstance().getDownInfos();
    }
}
