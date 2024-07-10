package com.techrevamp.controllers;

import com.techrevamp.models.Order;
import com.techrevamp.models.User;
import com.techrevamp.services.OrderService;
import com.techrevamp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        // Verificar si el campo 'user' está correctamente inicializado
//        if(order.getUser().getUserId() != null){
//            Long userId = order.getUser().getUserId();
//            User user = userService.getUserById(userId);
//            order.setUser(user);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        
        if (order.getUser() == null){
            return ResponseEntity.notFound().build();
        }
        
        // Crear la orden
        Order createdOrder = orderService.createOrder(order);
        
        // Devolver respuesta con la orden creada
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(orderId, order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    //formato ISO de fecha (yyyy-MM-dd).
    @GetMapping("/date/{orderDate}")
    public List<Order> getOrdersByOrderDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate orderDate) {
        return orderService.getOrdersByOrderDate(orderDate);
    }

    @GetMapping("/code/{orderCode}")
    public Order getOrderByOrderCode(@PathVariable String orderCode) {
        return orderService.getOrderByOrderCode(orderCode);
    }

}