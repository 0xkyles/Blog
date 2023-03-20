package com.example.blog.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class APIException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public APIException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
