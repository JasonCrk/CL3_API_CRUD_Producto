package com.cibertec.cl3.models.mappers;

import com.cibertec.cl3.models.Product;
import com.cibertec.cl3.models.dto.ProductRequest;
import com.cibertec.cl3.models.dto.ProductResponse;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toModel(ProductRequest request) {
        return Product.builder()
                .description(request.description())
                .price(request.price())
                .stock(request.stock())
                .build();
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getDescription(),
                product.getRegistrationDate(),
                product.getPrice(),
                product.getStock()
        );
    }
}
