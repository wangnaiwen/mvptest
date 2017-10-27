package com.wnw.wnw.mvptest.exception;

/**
 * @author wnw
 * @date 2017/10/25 0025 16:06
 */
public class ApiException extends RuntimeException {

    public String code;
    public String message;
    public String status;


    public ApiException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiException(String code, String message, String status) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

