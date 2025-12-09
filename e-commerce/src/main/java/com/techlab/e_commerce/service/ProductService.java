package com.techlab.e_commerce.service;

import com.techlab.e_commerce.entity.Product;
import com.techlab.e_commerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        System.out.println("Producto ingresado: " + product);

        return this.productRepository.save(product);
    }
}
