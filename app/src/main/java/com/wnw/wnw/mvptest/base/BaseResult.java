package com.wnw.wnw.mvptest.base;

import java.io.Serializable;

/**
 * @author wnw
 * @date 2017/10/25 0025 15:57
 */
public class BaseResult<T> implements Serializable {
    private String status;//返回值："ok","error"
    private String msg;//错误信息
    private String code;//错误码
    private T data;

    public String getState() {
        return status;
    }

    public void setState(String state) {
        this.status = state;
    }

    public String getError() {
        return msg;
    }

    public void setError(String error) {
        this.msg = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
