package com.example.homework_week_5.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundUserException.class)
    public ExceptionResponse handlerException(NotFoundUserException ex) {
        return new ExceptionResponse(ex.getMessage(), ex.getStatus());
    }

    @ExceptionHandler(UserExistedException.class)
    public ExceptionResponse handlerException(UserExistedException ex) {
        return new ExceptionResponse(ex.getMessage(), ex.getStatus());
    }
}
