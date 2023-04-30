package com.misikovich.javaprodz14glovo.controller;

import com.misikovich.javaprodz14glovo.model.Product;
import com.misikovich.javaprodz14glovo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return this.productService.getProduct(id);
    }

    @PostMapping("/{id}/delete")
    public Product deleteProduct(@PathVariable Long id) {
        return this.productService.deleteProduct(id);
    }

    @PostMapping("/{id}/update")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return this.productService.updateProduct(id, product);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return this.productService.addProduct(product);
    }
}
