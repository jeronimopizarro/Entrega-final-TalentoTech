package com.techlab.e_commerce.service;

import com.techlab.e_commerce.entity.Product;
import com.techlab.e_commerce.exception.NotFoundException;
import com.techlab.e_commerce.repository.ProductRepository;
import com.techlab.e_commerce.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {

    private final ProductRepository productRepository;
    private final StringUtils stringUtils;

    public ProductServiceImpl(ProductRepository productRepository, StringUtils stringUtils) {
        this.productRepository = productRepository;
        this.stringUtils = stringUtils;
    }

    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }

    public Product getProductById(Long id) {
        Optional<Product> productOptional = this.productRepository.findById(id);

        if (productOptional.isEmpty()) {
            throw  new NotFoundException("Producto no encontrado con ID: " + id);
        }

        return productOptional.get();
    }


    public List<Product> findAllProducts(String name, String category) {

        if (!name.isEmpty() && !category.isEmpty()) {
            return this.productRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
        }

        if (!name.isEmpty()) {
            return this.productRepository.findByNameContainingIgnoreCase(name);
        }

        if (!category.isEmpty()) {
            return this.productRepository.findByCategoryContainingIgnoreCase(category);
        }

        return this.productRepository.findAll();
    }

    public Product editProductById(Long id, Product dataToEdit) {
        Product product = this.getProductById(id);

        if (!stringUtils.isEmpty(dataToEdit.getName())) {
            product.setName(dataToEdit.getName());
        }

        if (!stringUtils.isEmpty(dataToEdit.getDescription())) {
            product.setDescription(dataToEdit.getDescription());
        }

        if (!stringUtils.isEmpty(dataToEdit.getCategory())) {
            product.setCategory(dataToEdit.getCategory());
        }

        if (dataToEdit.getPrice() != null) {
            if (dataToEdit.getPrice() < 0) {
                throw new IllegalArgumentException("El precio no puede ser negativo");
            }
            product.setPrice(dataToEdit.getPrice());
        }
        if (dataToEdit.getStock() != null) {
            if (dataToEdit.getStock() < 0) {
                throw new IllegalArgumentException("El stock no puede ser negativo");
            }
            product.setStock(dataToEdit.getStock());
        }

        return this.productRepository.save(product);
    }

    public Product deleteProductById(Long id) {
        Product product = this.getProductById(id);
        this.productRepository.delete(product);
        return product;
    }
}
