package com.cibertec.cl3.models.dto;

import jakarta.validation.constraints.*;

public record ProductRequest(
        @NotBlank(message = "The description is required")
        @Size(max = 255, message = "The description only allows a maximum of 255 characters")
        String description,

        @NotNull(message = "The price is required")
        @DecimalMin(value = "00.1", message = "The price cannot be negative")
        double price,

        @NotNull(message = "The stock is required")
        @Positive(message = "The stock cannot be negative")
        int stock
) {
}
