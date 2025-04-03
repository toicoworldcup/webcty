package com.example.webcty.services.impl;

import com.example.webcty.dto.request.ProductRequest;
import com.example.webcty.dto.response.ProductResponse;
import com.example.webcty.entities.Product;
import com.example.webcty.repositories.ProductRepository;
import com.example.webcty.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductResponse convertToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setTitle(product.getTitle());
        response.setContent(product.getContent());
        response.setSlug(product.getSlug());
        return response;
    }

    private Product convertToEntity(ProductRequest request) {
        Product product = new Product();
        product.setTitle(request.getTitle());
        product.setContent(request.getContent());
        product.setSlug(request.getSlug());
        return product;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productRepository.findById(id).map(this::convertToResponse).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product newProduct = convertToEntity(request);
        Product savedProduct = productRepository.save(newProduct);
        return convertToResponse(savedProduct);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existingProduct.setTitle(request.getTitle());
        existingProduct.setContent(request.getContent());
        existingProduct.setSlug(request.getSlug());

        Product updatedProduct = productRepository.save(existingProduct);
        return convertToResponse(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }
}