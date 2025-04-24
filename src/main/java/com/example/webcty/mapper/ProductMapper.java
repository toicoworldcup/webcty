package com.example.webcty.mapper;

import com.example.webcty.dto.request.ProductRequest;
import com.example.webcty.dto.response.ProductResponse;
import com.example.webcty.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequest dto) {
        Product product = new Product();
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());
        product.setTags(dto.getTags());
        product.setCreatedBy("admin"); // Mặc định created_by là admin
        return product;
    }

    public ProductResponse toResponseDTO(Product entity) {
        ProductResponse dto = new ProductResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        dto.setTags(entity.getTags());
        return dto;
    }
}