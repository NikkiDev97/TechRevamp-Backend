package com.techrevamp.repositories;

import com.techrevamp.models.ShoppingCart;
import com.techrevamp.models.ShoppingCartProduct;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
//    @Query("SELECT p FROM ShoppingCartProduct p WHERE p.shoppingCart.cartId = :cartId")
//    List<ShoppingCartProduct> findProductsByCartId(@Param("cartId") Long cartId);

//    @Modifying
//    @Transactional
//    @Query("DELETE FROM ShoppingCartProduct p WHERE p.shoppingCart.cartId = :cartId AND p.product.productId = :productId")
//    void deleteProductFromCart(@Param("cartId") Long cartId, @Param("productId") Long productId);
//
//    @Modifying
//    @Transactional
//    @Query("UPDATE ShoppingCartProduct p SET p.quantity = :quantity WHERE p.shoppingCart.cartId = :cartId AND p.product.productId = :productId")
//    void updateProductQuantityInCart(@Param("cartId") Long cartId, @Param("productId") Long productId, @Param("quantity") int quantity);
}
