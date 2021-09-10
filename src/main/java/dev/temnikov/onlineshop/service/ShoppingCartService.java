package dev.temnikov.onlineshop.service;

import dev.temnikov.onlineshop.domain.model.Product;
import dev.temnikov.onlineshop.domain.model.ProductInShoppingCart;
import dev.temnikov.onlineshop.domain.model.ShoppingCart;
import dev.temnikov.onlineshop.repository.ProductInShoppingCartRepository;
import dev.temnikov.onlineshop.repository.ProductRepository;
import dev.temnikov.onlineshop.repository.ShoppingCartRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;
    private ProductInShoppingCartRepository productInShoppingCartRepository;
    private ProductService productService;
    private ProductRepository productRepository;

    private ShoppingCart generateShoppingCart(Long id) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(id);
        List<ProductInShoppingCart> productInShoppingCartList = new ArrayList<>();
        shoppingCart.setProducts(productInShoppingCartList);
        shoppingCart.calculateSum();
        return shoppingCart;
    }

    private int getRandomNumber() {
        return ((int) (Math.random() * 5) + 1);
    }

    private ProductInShoppingCart generateProductInShoppingCart(int id) {
        ProductInShoppingCart productInShoppingCart = new ProductInShoppingCart();
        Product product = new Product();
        productInShoppingCart.setProductName(product.getTitle());
        productInShoppingCart.setQuantity(getRandomNumber());
        productInShoppingCart.setPrice(product.getPrice());
        productInShoppingCart.calculateSum();
        return productInShoppingCart;
    }

    public ShoppingCart getShoppingCartById(Long id) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        if (shoppingCartOptional.isEmpty()) {
            return createShoppingCart(id);
        }
        return shoppingCartOptional.get();
    }

    private ShoppingCart createShoppingCart(Long id) {
        ShoppingCart shoppingCart = generateShoppingCart(id);
        shoppingCart.setId(id);
        ShoppingCart save = shoppingCartRepository.save(shoppingCart);
        return save;
    }

    public void deleteShoppingCartById(Long cartId) {
        shoppingCartRepository.deleteById(cartId);
    }

    public ShoppingCart putProductToCart(Long cartId) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartId);
        if (shoppingCartOptional.isEmpty()) {
            ShoppingCart cart = new ShoppingCart();
            List<ProductInShoppingCart> productInShoppingCartList = new ArrayList<>();
            cart.setProducts(productInShoppingCartList);
            shoppingCartOptional = Optional.of(cart);
        }
        ShoppingCart resultCart = shoppingCartOptional.get();
        Product productById = productService.getProductById(1l);
        ProductInShoppingCart newProduct = new ProductInShoppingCart();
        newProduct.setProductName(productById.getTitle());
        newProduct.setPrice(productById.getPrice());
        newProduct.calculateSum();
        resultCart.getProducts().add(newProduct);
        resultCart.calculateSum();
        shoppingCartRepository.save(resultCart);
        return resultCart;
    }
}
