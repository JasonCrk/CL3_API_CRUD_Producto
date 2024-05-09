package com.cibertec.cl3.exceptions;

public record ApiErrorMessage(
        String message,
        String error,
        int code
) {
}
