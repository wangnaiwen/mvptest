package com.wnw.wnw.mvptest.download;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * The type Down info.
 *
 * @author wnw
 * @date 2017 /10/26 0026 15:29
 */
@Entity
public class DownInfo {
    @Id
    private long id;
    /**
     *
     * 存储位置
     *
     * */
    private String savePath;
    /**
     *
     * 文件总长度
     *
     * */
    private long countLength;
    /**
     *
     * 下载长度
     *
     * */
    private long readLength;
    /**
     *
     * 下载唯一的HttpService
     *
     * */
    @Transient
    private HttpDownService service;
    /**
     *
     * 回调监听
     *
     * */
    @Transient
    private HttpDownOnNextListener listener;
    /**
     *
     * 超时设置
     *
     * */
    private  int connectionTime = 6;
    /**
     *
     * state状态数据库保存
     *
     * */
    private int status;
    /**
     *
     * url
     *
     * */
    private String url;

    /**
     * Instantiates a new Down info.
     *
     * @param url      the url
     * @param listener the listener
     */
    public DownInfo(String url,HttpDownOnNextListener listener) {
        setUrl(url);
        setListener(listener);
    }

    /**
     * Instantiates a new Down info.
     *
     * @param url the url
     */
    public DownInfo(String url) {
        setUrl(url);
    }

    /**
     * Instantiates a new Down info.
     *
     * @param id             the id
     * @param savePath       the save path
     * @param countLength    the count length
     * @param readLength     the read length
     * @param connectionTime the connection time
     * @param status         the status
     * @param url            the url
     */
    @Keep
    public DownInfo(long id, String savePath, long countLength, long readLength,
                     int connectionTime, int status, String url) {
        this.id = id;
        this.savePath = savePath;
        this.countLength = countLength;
        this.readLength = readLength;
        this.connectionTime = connectionTime;
        this.status = status;
        this.url = url;
    }

    /**
     * Instantiates a new Down info.
     */
    @Keep
    public DownInfo() {
    }


    /**
     * Gets state.
     *
     * @return the state
     */
    public DownState getState() {
        switch (getStatus()){
            case 0:
                return DownState.START;
            case 1:
                return DownState.DOWN;
            case 2:
                return DownState.PAUSE;
            case 3:
                return DownState.STOP;
            case 4:
                return DownState.ERROR;
            case 5:
            default:
                return DownState.FINISH;
        }
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(DownState state) {
        setStatus(state.getState());
    }


    /**
     * Gets connection time.
     *
     * @return the connection time
     */
    public int getConnectionTime() {
        return connectionTime;
    }

    /**
     * Sets connection time.
     *
     * @param connectionTime the connection time
     */
    public void setConnectionTime(int connectionTime) {
        this.connectionTime = connectionTime;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets listener.
     *
     * @return the listener
     */
    public HttpDownOnNextListener getListener() {
        return listener;
    }

    /**
     * Sets listener.
     *
     * @param listener the listener
     */
    public void setListener(HttpDownOnNextListener listener) {
        this.listener = listener;
    }

    /**
     * Gets service.
     *
     * @return the service
     */
    public HttpDownService getService() {
        return service;
    }

    /**
     * Sets service.
     *
     * @param service the service
     */
    public void setService(HttpDownService service) {
        this.service = service;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets save path.
     *
     * @return the save path
     */
    public String getSavePath() {
        return savePath;
    }

    /**
     * Sets save path.
     *
     * @param savePath the save path
     */
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }


    /**
     * Gets count length.
     *
     * @return the count length
     */
    public long getCountLength() {
        return countLength;
    }

    /**
     * Sets count length.
     *
     * @param countLength the count length
     */
    public void setCountLength(long countLength) {
        this.countLength = countLength;
    }


    /**
     * Gets read length.
     *
     * @return the read length
     */
    public long getReadLength() {
        return readLength;
    }

    /**
     * Sets read length.
     *
     * @param readLength the read length
     */
    public void setReadLength(long readLength) {
        this.readLength = readLength;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return this.id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

}
