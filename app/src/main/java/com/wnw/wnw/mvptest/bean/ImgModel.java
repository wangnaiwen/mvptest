package com.wnw.wnw.mvptest.bean;

import java.io.Serializable;

/**
 *
 * @author wnw
 *
 * @date 2017/10/25 0025 16:46
 *
 */

public class ImgModel implements Serializable {
    private String hash;
    private String key;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
