package com.zeal.mall.exception;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description:
 * @date: 2022-06-11 18:24
 */
public class ImoocMallException extends RuntimeException{
    private final Integer code;
    private final String message;

    public ImoocMallException(Integer code, String message){
        this.code=code;
        this.message=message;
    }

    public ImoocMallException(ImoocMallExceptionEnum exceptionEnum){
        this(exceptionEnum.getCode(),exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
