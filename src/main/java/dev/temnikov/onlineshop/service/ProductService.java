package dev.temnikov.onlineshop.service;

import dev.temnikov.onlineshop.domain.model.Product;
import dev.temnikov.onlineshop.repository.ProductRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository repository) {
        this.productRepository = repository;
    }

    public Product getProductById(Long productId) {
        Optional<Product> optionalProductById = productRepository.findById(productId);
        return optionalProductById.orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
    }

    public Product putProductById(Product product) {
        return productRepository.save(product);
    }

}

