package com.cduestc.keep.dto;

import lombok.Data;

@Data
public class ResultDto<T> {
    private Integer code;
    private String message;
    private T data;

public ResultDto(Integer code,String message){
        this.code=code;
        this.message=message;
    }
    public ResultDto(){

    }
    public static ResultDto errorOf(Integer code,String message){
        ResultDto resultDto=new ResultDto();
                resultDto.setCode(code);
                resultDto.setMessage(message);
          return resultDto;
    }
    public static<T> ResultDto oxOf(T t)
    {
        ResultDto resultDto=new ResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("请求成功");
        resultDto.setData(t);
        return resultDto;
    }
    public static ResultDto oxOf()
    {
        ResultDto resultDto=new ResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("请求成功");
        return resultDto;
    }
}
