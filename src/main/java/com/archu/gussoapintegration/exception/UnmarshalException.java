package com.archu.gussoapintegration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UnmarshalException extends RuntimeException {
    public UnmarshalException() {
        super();
    }

    public UnmarshalException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnmarshalException(String message) {
        super(message);
    }

    public UnmarshalException(Throwable cause) {
        super(cause);
    }
}