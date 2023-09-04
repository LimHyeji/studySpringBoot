package com.test.study.util.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<BusinessExceptionEntity> exceptionHandler(HttpServletRequest request, final BusinessException e){
        return ResponseEntity.status(e.getError().getStatus())
                .body(BusinessExceptionEntity.builder()
                        .errorCode(e.getError().getErrorCode())
                        .errorMessage(e.getError().getErrorMessage())
                        .build());
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<BusinessExceptionEntity> exceptionHandler(HttpServletRequest request, final ValidationException e){
        return ResponseEntity.status(e.getError().getStatus())
                .body(BusinessExceptionEntity.builder()
                        .errorCode(e.getError().getErrorCode())
                        .errorMessage(e.getError().getErrorMessage())
                        .build());
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<BusinessExceptionEntity> exceptionHandler(HttpServletRequest request, final NotFoundException e){
        return ResponseEntity.status(e.getError().getStatus())
                .body(BusinessExceptionEntity.builder()
                        .errorCode(e.getError().getErrorCode())
                        .errorMessage(e.getError().getErrorMessage())
                        .build());
    }

    @ExceptionHandler({AlreadyExistException.class})
    public ResponseEntity<BusinessExceptionEntity> exceptionHandler(HttpServletRequest request, final AlreadyExistException e){
        return ResponseEntity.status(e.getError().getStatus())
                .body(BusinessExceptionEntity.builder()
                        .errorCode(e.getError().getErrorCode())
                        .errorMessage(e.getError().getErrorMessage())
                        .build());
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<BusinessExceptionEntity> exceptionHandler(HttpServletRequest request, final AccessDeniedException e){
        return ResponseEntity.status(e.getError().getStatus())
                .body(BusinessExceptionEntity.builder()
                        .errorCode(e.getError().getErrorCode())
                        .errorMessage(e.getError().getErrorMessage())
                        .build());
    }

}
