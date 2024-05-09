package com.cibertec.cl3.controllers;

import com.cibertec.cl3.models.dto.MessageResponse;
import com.cibertec.cl3.models.dto.ProductRequest;
import com.cibertec.cl3.models.dto.ProductResponse;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductController {
    ResponseEntity<List<ProductResponse>> getAll();
    ResponseEntity<MessageResponse> create(
            @Valid @RequestBody ProductRequest request
    );
    ResponseEntity<MessageResponse> update(
            @PathVariable("id") Integer productId,
            @Valid @RequestBody ProductRequest request
    );
    ResponseEntity<MessageResponse> delete(
            @PathVariable("id") Integer productId
    );
}
