package com.cibertec.cl3.models.dto;

import java.time.LocalDate;

public record ProductResponse(
        Integer id,
        String description,
        LocalDate registrationDate,
        double price,
        int stock
) {
}
