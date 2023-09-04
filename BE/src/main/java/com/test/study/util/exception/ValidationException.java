package com.test.study.util.exception;

public class ValidationException extends BusinessException{

    public ValidationException(ExceptionEnum e) {
        super(e);
    }
}
