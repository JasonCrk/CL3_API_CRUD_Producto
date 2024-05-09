package com.cibertec.cl3.services;

import com.cibertec.cl3.models.dto.MessageResponse;
import com.cibertec.cl3.models.dto.ProductRequest;
import com.cibertec.cl3.models.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Integer id);
    MessageResponse createProduct(ProductRequest request);
    MessageResponse updateProduct(Integer id, ProductRequest request);
    MessageResponse deleteProduct(Integer id);
}
