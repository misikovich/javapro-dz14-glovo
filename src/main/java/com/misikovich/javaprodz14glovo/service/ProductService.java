package com.misikovich.javaprodz14glovo.service;

import com.misikovich.javaprodz14glovo.model.Product;
import com.misikovich.javaprodz14glovo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProduct(Long id) {
        return productRepository.get(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.update(product);
    }

    public Product deleteProduct(Long id) {
        return productRepository.delete(id);
    }
}
