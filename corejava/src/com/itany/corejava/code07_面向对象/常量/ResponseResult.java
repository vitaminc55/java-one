package com.itany.corejava.code07_面向对象.常量;

/**
 * @author 石小俊
 * @date 2023年08月18日 14:01
 */
public class ResponseResult {

    private String responseCode;
    private String message;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
