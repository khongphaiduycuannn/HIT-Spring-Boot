package com.example.homework_week_6.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundIdException.class)
    public ErrorResponse handlerNotFoundIdException(NotFoundIdException ex) {
        return new ErrorResponse(ex.getMessage(), ex.getStatus());
    }
}
