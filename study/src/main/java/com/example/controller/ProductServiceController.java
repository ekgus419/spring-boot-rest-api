package com.example.controller;

import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.model.Product;
@RestController
@RequiredArgsConstructor
public class ProductServiceController {
    private final ProductService productService;
    @GetMapping("/products")
    public ResponseEntity readProducts() {
        return ResponseEntity.ok(productService.readProductAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> readProduct (@PathVariable Long id) {
        return ResponseEntity.ok(productService.readProduct(id));
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct (@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct (@RequestBody Product product) {
        Product newProduct = productService.readProduct(product.getId());
        newProduct.setName(product.getName());
        return ResponseEntity.ok(productService.saveProduct(newProduct));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct (@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
