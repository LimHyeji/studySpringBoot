package com.test.study.util.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

    private ExceptionEnum error;

    public BusinessException(ExceptionEnum e){
        super(e.getErrorMessage());
        this.error=e;
    }
}
