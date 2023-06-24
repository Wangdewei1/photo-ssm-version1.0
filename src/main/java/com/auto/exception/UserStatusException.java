package com.auto.exception;

import com.auto.en.ResultEntity;

/**
 * 用户状态异常
 */
public class UserStatusException extends Exception{

    Integer code;

    public UserStatusException() {
    }

    public UserStatusException(String message) {
        super(message);
    }

    public UserStatusException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
