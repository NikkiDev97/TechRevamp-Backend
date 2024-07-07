package com.techrevamp.services;

import com.techrevamp.models.ShoppingCart;
import com.techrevamp.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    // Método para obtener todos los carritos de compra
    public List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    // Método para obtener un carrito de compra por su ID
    public ShoppingCart getShoppingCartById(Long cartId) {
        Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(cartId);
        return cartOptional.orElse(null);
    }

    // Método para crear un nuevo carrito de compra
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    // Método para eliminar un carrito de compra por su ID
    public void deleteShoppingCart(Long cartId) {
        shoppingCartRepository.deleteById(cartId);
    }
}
