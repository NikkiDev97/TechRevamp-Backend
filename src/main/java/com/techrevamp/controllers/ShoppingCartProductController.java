package com.techrevamp.controllers;

import com.techrevamp.models.ShoppingCartProduct;
import com.techrevamp.services.ShoppingCartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shopping-carts/products")
public class ShoppingCartProductController {
  @Autowired
  private ShoppingCartProductService shoppingCartProductService;
  
  // Endpoint para obtener todos los carritos de compra
  @GetMapping
  public List<ShoppingCartProduct> getAllShoppingCartProducts() {
    return shoppingCartProductService.getAllShoppingCartProducts();
  }
  
  // Endpoint para obtener un carrito de compra por su cartID
  @GetMapping("/{cartId}")
  public ShoppingCartProduct getShoppingCartProductByCartId(@PathVariable Long cartId) {
    return shoppingCartProductService.getShoppingCartProductByCartId(cartId);
  }
  
  // Endpoint para obtener un carrito de compra por su product ID
  @GetMapping("/{productId}")
  public ShoppingCartProduct getShoppingCartProductByProductId(@PathVariable Long productId) {
    return shoppingCartProductService.getShoppingCartProductByProductId(productId);
  }
  
  // Endpoint para crear un nuevo carrito de compra
  @PostMapping
  public ShoppingCartProduct createShoppingCartProduct(@RequestBody ShoppingCartProduct shoppingCartProduct) {
    return shoppingCartProductService.createShoppingCartProduct(shoppingCartProduct);
  }
}
