package dev.temnikov.onlineshop.repository;

import dev.temnikov.onlineshop.domain.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
