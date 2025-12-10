package com.techlab.e_commerce.service;

import com.techlab.e_commerce.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProduct(Long id);
    List<Product> getAllProducts(String name, String category);
    Product editProductById(Long id, Product dataToEdit);
    Product deleteProductById(Long id);
}
