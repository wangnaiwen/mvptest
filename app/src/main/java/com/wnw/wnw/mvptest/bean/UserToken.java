package com.wnw.wnw.mvptest.bean;

import java.io.Serializable;

/**
 * Created by yue on 17/8/1.
 */

public class UserToken implements Serializable {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
