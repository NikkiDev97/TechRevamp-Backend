package com.techrevamp.repositories;

import com.techrevamp.models.Order;
import com.techrevamp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);

//    @Query("SELECT o FROM Order o WHERE o.userId = :userId")
//    List<Order> findOrderByUserId(@Param("userId") Long userId);

    @Query("SELECT o FROM Order o WHERE o.orderDate = :orderDate")
    List<Order> findByOrderDate(@Param("orderDate") LocalDate orderDate);

    @Query("SELECT o FROM Order o WHERE o.orderCode = :orderCode")
    Order findByOrderCode(@Param("orderCode") String orderCode);
}
