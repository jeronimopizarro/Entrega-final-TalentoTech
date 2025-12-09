package com.techlab.e_commerce.controller;

import com.techlab.e_commerce.entity.Product;
import com.techlab.e_commerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return this.productService.createProduct(product);
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return this.productService.getProductById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(@RequestParam(required = false, defaultValue = "") String name,
                                        @RequestParam(required = false, defaultValue = "") String category) {
        return this.productService.findAllProducts(name, category);
    }

    @PutMapping("/products/{id}")
    public Product editProductById(@PathVariable Long id, @RequestBody Product dataToEdit) {
        return this.productService.editProductById(id, dataToEdit);
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProductById(@PathVariable Long id) {
        return this.productService.deleteProductById(id);
    }
}
