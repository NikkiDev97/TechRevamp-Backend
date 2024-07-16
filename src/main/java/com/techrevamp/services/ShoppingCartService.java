package com.techrevamp.services;

import com.techrevamp.models.ShoppingCart;
import com.techrevamp.models.ShoppingCartProduct;
import com.techrevamp.repositories.ShoppingCartRepository;
import jakarta.transaction.Transactional;
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

    // Método para actualizar un carrito de compra
    @Transactional
    public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
        // Verificar si el carrito existe
        Long cartId = shoppingCart.getCartId();
        Optional<ShoppingCart> existingCartOptional = shoppingCartRepository.findById(cartId);
        if (existingCartOptional.isEmpty()) {
            throw new RuntimeException("Shopping cart not found with id: " + cartId);
        }

        // Actualizar el carrito existente con los nuevos datos
        ShoppingCart existingCart = existingCartOptional.get();
        existingCart.setUser(shoppingCart.getUser()); // Actualiza el usuario si es necesario
        existingCart.setCreationDate(shoppingCart.getCreationDate()); // Actualiza la fecha de creación

        return shoppingCartRepository.save(existingCart);
    }
}
