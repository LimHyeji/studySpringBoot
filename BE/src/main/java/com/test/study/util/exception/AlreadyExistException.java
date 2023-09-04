package com.test.study.util.exception;

public class AlreadyExistException extends BusinessException{

    public AlreadyExistException(ExceptionEnum e) {
        super(e);
    }
}
