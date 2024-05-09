package com.cibertec.cl3.services;

import com.cibertec.cl3.models.Product;
import com.cibertec.cl3.models.dto.MessageResponse;
import com.cibertec.cl3.models.dto.ProductRequest;
import com.cibertec.cl3.models.dto.ProductResponse;
import com.cibertec.cl3.models.mappers.ProductMapper;
import com.cibertec.cl3.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return this.repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponse getProductById(Integer id) {
        var product = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The product does not exist"));

        return mapper.toResponse(product);
    }

    @Override
    @Transactional
    public MessageResponse createProduct(ProductRequest request) {
        this.repository.save(mapper.toModel(request));
        return new MessageResponse("The product has been created successfully");
    }

    @Override
    @Transactional
    public MessageResponse updateProduct(Integer id, ProductRequest request) {
        Product product = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "The product does not exist"
                ));

        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStock(request.stock());

        this.repository.save(product);

        return new MessageResponse("The product has been updated successfully");
    }

    @Override
    @Transactional
    public MessageResponse deleteProduct(Integer id) {
        Product product = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "The product does not exist"
                ));

        this.repository.delete(product);

        return new MessageResponse("The product has been deleted successfully");
    }
}
