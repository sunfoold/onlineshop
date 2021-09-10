package dev.temnikov.onlineshop.repository;

import dev.temnikov.onlineshop.domain.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
