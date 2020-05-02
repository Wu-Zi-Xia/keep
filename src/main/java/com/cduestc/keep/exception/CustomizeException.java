package com.cduestc.keep.exception;
//自定义异常类
public class CustomizeException extends RuntimeException{
    private String message;
    private Integer code;
    public CustomizeException(ICustomizeErrorCode errorCode) {//多态的应用
        this.message =errorCode.getMessage();
        this.code=errorCode.getCode();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
