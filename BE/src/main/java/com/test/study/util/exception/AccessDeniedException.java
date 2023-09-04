package com.test.study.util.exception;

public class AccessDeniedException extends BusinessException{

    public AccessDeniedException(ExceptionEnum e) {
        super(e);
    }
}
