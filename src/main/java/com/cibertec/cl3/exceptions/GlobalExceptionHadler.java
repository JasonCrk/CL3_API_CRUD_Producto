package com.cibertec.cl3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorMessage> validationExceptionHandler(
            MethodArgumentNotValidException exception
    ) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(new ValidationErrorMessage(errors), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
