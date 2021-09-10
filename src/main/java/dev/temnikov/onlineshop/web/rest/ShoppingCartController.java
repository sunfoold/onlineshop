package dev.temnikov.onlineshop.web.rest;

import dev.temnikov.onlineshop.domain.model.ShoppingCart;
import dev.temnikov.onlineshop.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart/")
@AllArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @GetMapping("{cartId}")
    @Transactional()
    public ResponseEntity<ShoppingCart> getCartById(@PathVariable Long cartId) {
        return ResponseEntity.ok(shoppingCartService.getShoppingCartById(cartId));
    }

    @DeleteMapping("{cartId}")
    @Transactional()
    public void deleteCartById(@PathVariable Long cartId) {
        shoppingCartService.deleteShoppingCartById(cartId);
    }

    @PutMapping("{cartId}")
    @Transactional()
    public ResponseEntity<ShoppingCart> putDefaultProductToCart(@PathVariable Long cartId) {
        return ResponseEntity.ok(shoppingCartService.putProductToCart(cartId));
    }

}
