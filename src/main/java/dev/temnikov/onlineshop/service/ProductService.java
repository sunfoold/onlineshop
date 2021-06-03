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

    public Product putProductById(Long productId, Product product) {
        Optional<Product> optionalProductById = productRepository.findById(productId);
        if (optionalProductById.isEmpty()) {
            product.setId(productId);
            return productRepository.save(product);
        }

        Product product1 = optionalProductById.get();
        product1.setTitle(product.getTitle());

        return productRepository.save(product1);
    }
}
