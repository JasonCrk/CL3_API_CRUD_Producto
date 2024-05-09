package com.cibertec.cl3.exceptions;

import java.util.Map;

public record ValidationErrorMessage(
        Map<String, String> errors
) {
}
