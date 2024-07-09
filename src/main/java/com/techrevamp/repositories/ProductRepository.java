package com.techrevamp.repositories;

import com.techrevamp.models.Product;
import com.techrevamp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//  @Query("SELECT p FROM Product p WHERE p.category = :category")
//  List<Product> findByCategory(@Param("category") String category);
//
//  @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
//  List<Product> findByName(@Param("name") String name);
//
//  @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
//  List<Product> findByPriceBetween(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);
}
