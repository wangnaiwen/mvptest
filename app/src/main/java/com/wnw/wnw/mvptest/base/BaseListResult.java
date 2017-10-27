package com.wnw.wnw.mvptest.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author wnw
 * @date 2017/10/25 0025 15:58
 */
public class BaseListResult<T>  implements Serializable {
    private String status;
    private List<T> data;
    private String msg;

    public String getState() {
        return status;
    }

    public void setState(String state) {
        this.status = state;
    }

    public List<T> getList() {
        return data;
    }

    public void setList(List<T> list) {
        this.data = list;
    }

    public String getError() {
        return msg;
    }

    public void setError(String error) {
        this.msg = error;
    }
}
