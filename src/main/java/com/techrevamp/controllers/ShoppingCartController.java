package com.techrevamp.controllers;

import com.techrevamp.models.ShoppingCart;
import com.techrevamp.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shopping-carts")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    // Endpoint para obtener todos los carritos de compra
    @GetMapping
    public List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartService.getAllShoppingCarts();
    }

    // Endpoint para obtener un carrito de compra por su ID
    @GetMapping("/{cartId}")
    public ShoppingCart getShoppingCartById(@PathVariable Long cartId) {
        return shoppingCartService.getShoppingCartById(cartId);
    }

    // Endpoint para crear un nuevo carrito de compra
    @PostMapping
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.createShoppingCart(shoppingCart);
    }

    // Endpoint para actualizar un carrito de compra existente
//    @PutMapping("/{cartId}")
//    public ShoppingCart updateShoppingCart(@PathVariable Long cartId, @RequestBody ShoppingCart shoppingCart) {
//        return shoppingCartService.updateShoppingCart(cartId, shoppingCart);
//    }

    // Endpoint para eliminar un carrito de compra por su ID
    @DeleteMapping("/{cartId}")
    public void deleteShoppingCart(@PathVariable Long cartId) {
        shoppingCartService.deleteShoppingCart(cartId);
    }
}
