package com.cduestc.keep.controller;

import com.cduestc.keep.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(CustomizeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handleException(CustomizeException e){
       Map<String,Object> map=new HashMap<>();
       map.put("code",e.getCode());
       map.put("message",e.getMessage());
       return map;
    }
}
