package com.example.mydemo.network.bean;

import java.io.Serializable;

/**
 * Created by user on 2018/4/19.
 * <p>
 * 解析基类
 */

public class BaseBean<T> {

    public static final int SUCCESS_CODE = 200;//成功code
    public static final int TOKEN_INVALID = 201;//token失效

    private T data;
    private String devMsg;
    private int resCode;
    private String userMsg;


    public boolean isSuccess() {
        return resCode == SUCCESS_CODE;
    }

    public boolean isTokenInvalid() {
        return resCode == TOKEN_INVALID;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDevMsg() {
        return devMsg;
    }

    public void setDevMsg(String devMsg) {
        this.devMsg = devMsg;
    }

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getUserMsg() {
        return userMsg;
    }

    public void setUserMsg(String userMsg) {
        this.userMsg = userMsg;
    }
}
