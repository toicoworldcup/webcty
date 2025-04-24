package com.example.webcty.services.impl;

import com.example.webcty.dto.request.ProductRequest;
import com.example.webcty.dto.response.ProductResponse;
import com.example.webcty.entities.Product;
import com.example.webcty.mapper.ProductMapper;
import com.example.webcty.repositories.ProductRepository;
import com.example.webcty.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.productMapper = new ProductMapper();
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product != null ? productMapper.toResponseDTO(product) : null;
    }

    @Override
    public ProductResponse createProduct(ProductRequest productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponseDTO(savedProduct);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest updatedproductDTO) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setTitle(updatedproductDTO.getTitle());
            product.setDescription(updatedproductDTO.getDescription());
            product.setImage(updatedproductDTO.getImage());
            product.setTag(updatedproductDTO.getTag());
            Product updatedProduct = productRepository.save(product);
            return productMapper.toResponseDTO(updatedProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
