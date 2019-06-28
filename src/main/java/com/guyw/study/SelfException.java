package com.guyw.study;

/**
 * @author conangu
 * @createTime 2019-06-25 15:45
 * @description 自定义异常
 */
public class SelfException extends Exception {
    private String message;
    private String code;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SelfException(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
