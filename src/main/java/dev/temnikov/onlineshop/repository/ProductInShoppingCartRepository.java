package dev.temnikov.onlineshop.repository;

import dev.temnikov.onlineshop.domain.model.ProductInShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ProductInShoppingCartRepository extends CrudRepository<ProductInShoppingCart, Long> {
}
