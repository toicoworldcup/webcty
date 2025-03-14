package com.example.webcty.controllers;

import com.example.webcty.entities.Product;
import com.example.webcty.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // API lấy tất cả sản phẩm
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // API lấy sản phẩm theo ID
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // API tạo hoặc cập nhật sản phẩm
    @PostMapping
    public Product createOrUpdateProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // API xóa sản phẩm theo ID
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Xóa sản phẩm thành công!";
    }
}
