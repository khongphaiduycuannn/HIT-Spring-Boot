package com.example.homework_week_5.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NotFoundUserException extends RuntimeException{

    private String message;

    private String status;
}
