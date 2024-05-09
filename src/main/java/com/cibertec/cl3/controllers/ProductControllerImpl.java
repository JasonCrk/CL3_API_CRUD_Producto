package com.cibertec.cl3.controllers;

import com.cibertec.cl3.models.dto.MessageResponse;
import com.cibertec.cl3.models.dto.ProductRequest;
import com.cibertec.cl3.models.dto.ProductResponse;
import com.cibertec.cl3.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/products")
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService service;

    @Override
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.ok(this.service.getAllProducts());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(Integer id) {
        return ResponseEntity.ok(this.service.getProductById(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<MessageResponse> create(ProductRequest request) {
        return new ResponseEntity<>(this.service.createProduct(request), HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update(Integer productId, ProductRequest request) {
        return ResponseEntity.ok(this.service.updateProduct(productId, request));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> delete(Integer productId) {
        return ResponseEntity.ok(this.service.deleteProduct(productId));
    }
}
