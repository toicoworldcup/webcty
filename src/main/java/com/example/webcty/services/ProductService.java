package com.example.webcty.services;

import com.example.webcty.dto.request.ProductRequest;
import com.example.webcty.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    ProductResponse createProduct(ProductRequest product);

    ProductResponse updateProduct(Long id, ProductRequest updatedProduct);

    void deleteProduct(Long id);
}
