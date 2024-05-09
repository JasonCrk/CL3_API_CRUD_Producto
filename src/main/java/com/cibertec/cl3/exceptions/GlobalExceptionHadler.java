package com.cibertec.cl3.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHadler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrorMessage> ResponseStatusExceptionHandler(
            ResponseStatusException exception
    ) {
        var error = new ApiErrorMessage(
                exception.getMessage(),
                exception.getStatusCode().toString(),
                exception.getStatusCode().value()
        );
        return new ResponseEntity<>(error, exception.getStatusCode());
    }
}
