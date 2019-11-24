package com.lan.library.exception;

/**
 * @author Xiang Lan
 * Created on 2019-07-17 14:25
 */
public class UserNameEx extends RuntimeException {

    private String msg;

    public UserNameEx(String msg){
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
