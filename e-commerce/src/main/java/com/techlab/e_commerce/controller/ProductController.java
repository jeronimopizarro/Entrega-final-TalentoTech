package com.techlab.e_commerce.controller;

import com.techlab.e_commerce.entity.Product;
import com.techlab.e_commerce.service.ProductService;
import com.techlab.e_commerce.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController implements ProductService {

    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return this.productServiceImpl.createProduct(product);
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return this.productServiceImpl.getProductById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(@RequestParam(required = false, defaultValue = "") String name,
                                        @RequestParam(required = false, defaultValue = "") String category) {
        return this.productServiceImpl.findAllProducts(name, category);
    }

    @PutMapping("/products/{id}")
    public Product editProductById(@PathVariable Long id, @RequestBody Product dataToEdit) {
        return this.productServiceImpl.editProductById(id, dataToEdit);
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProductById(@PathVariable Long id) {
        return this.productServiceImpl.deleteProductById(id);
    }
}
