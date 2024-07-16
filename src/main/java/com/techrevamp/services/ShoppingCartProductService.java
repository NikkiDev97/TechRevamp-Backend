package com.techrevamp.services;

import com.techrevamp.models.ShoppingCart;
import com.techrevamp.models.ShoppingCartProduct;
import com.techrevamp.repositories.ShoppingCartProductRepository;
import com.techrevamp.repositories.ShoppingCartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartProductService {
  private final ShoppingCartProductRepository shoppingCartProductRepository;
  
  @Autowired
  public ShoppingCartProductService(ShoppingCartProductRepository shoppingCartProductRepository) {
    this.shoppingCartProductRepository = shoppingCartProductRepository;
  }
  
  // Método para obtener todos los carritos de compra
  public List<ShoppingCartProduct> getAllShoppingCartProducts() {
    return shoppingCartProductRepository.findAll();
  }
  
  // Método para obtener un carrito de compra con sus productos por su ID
  public ShoppingCartProduct getShoppingCartProductByCartId(Long cartId) {
    Optional<ShoppingCartProduct> cartProductOptional = shoppingCartProductRepository.findById(cartId);
    return cartProductOptional.orElse(null);
  }
  
  // Método para obtener un carrito de compra con sus productos por el id de sus productos
  public ShoppingCartProduct getShoppingCartProductByProductId(Long productId) {
    Optional<ShoppingCartProduct> cartProductOptional = shoppingCartProductRepository.findById(productId);
    return cartProductOptional.orElse(null);
  }
  
  // Método para crear un nuevo producto en carrito de compra
  public ShoppingCartProduct createShoppingCartProduct(ShoppingCartProduct shoppingCartProduct) {
    return shoppingCartProductRepository.save(shoppingCartProduct);
  }
  
  // Método para eliminar un carrito de compra por el id de su producto
  public void deleteShoppingCartProduct(Long ProductId) {
    shoppingCartProductRepository.deleteById(ProductId);
  }

    // Método para obtener productos en un carrito en específico
//    public List<ShoppingCartProduct> getProductsInCart(Long cartId) {
//        return shoppingCartProductRepository.findProductsByCartId(cartId);
//    }

    // Método para eliminar un producto del carrito específico
//    @Transactional
//    public void removeProductFromCart(Long cartId, Long productId) {
//      shoppingCartProductRepository.deleteProductFromCart(cartId, productId);
//    }

    // Método para actualizar la cantidad de un producto en carrito específico
//    @Transactional
//    public void updateProductQuantityInCart(Long cartId, Long productId, int quantity) {
//      shoppingCartProductRepository.updateProductQuantityInCart(cartId, productId, quantity);
//    }
}
