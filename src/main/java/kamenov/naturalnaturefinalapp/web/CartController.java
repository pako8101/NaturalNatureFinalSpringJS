package kamenov.naturalnaturefinalapp.web;


import kamenov.naturalnaturefinalapp.entity.CartItem;
import kamenov.naturalnaturefinalapp.entity.UserEntity;
import kamenov.naturalnaturefinalapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")

public class CartController {


    private final CartService cartService;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartItem> getCart(@AuthenticationPrincipal UserEntity user) {
        return cartService.getCartItems(user);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam Long productId,
                                            @RequestParam int quantity,
                                            @AuthenticationPrincipal UserEntity user) {
        cartService.addToCart(productId, quantity, user);
        return ResponseEntity.ok("Product added to cart");
    }

    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long cartItemId, @AuthenticationPrincipal UserEntity user) {
        cartService.removeFromCart(cartItemId, user);
        return ResponseEntity.ok("Product removed from cart");
    }

    @PostMapping("/clear")
    public ResponseEntity<String> clearCart(@AuthenticationPrincipal UserEntity user) {
        cartService.clearCart(user);
        return ResponseEntity.ok("Cart cleared");
    }
}
