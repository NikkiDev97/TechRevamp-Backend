package com.techrevamp.services;

import com.techrevamp.models.Order;
import com.techrevamp.models.User;
import com.techrevamp.repositories.OrderRepository;
import com.techrevamp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.orElse(null);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long orderId, Order updatedOrder) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order existingOrder = orderOptional.get();
            if (updatedOrder.getOrderCode() != null) {
                existingOrder.setOrderCode(updatedOrder.getOrderCode());
            }
            User updatedUser = updatedOrder.getUser();
            if (updatedUser != null) {
                Optional<User> userOptional = userRepository.findById(updatedUser.getUserId());
                if (userOptional.isPresent()) {
                    existingOrder.setUser(userOptional.get());
                } else {
                    throw new RuntimeException("El usuario especificado no existe en la base de datos.");
                }
            }
            return orderRepository.save(existingOrder);
        } else {
            throw new RuntimeException("No se encontró la orden con el ID especificado.");
        }
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public List<Order> getOrdersByOrderDate(LocalDate orderDate) {
        return orderRepository.findByOrderDate(orderDate);
    }

    public Order getOrderByOrderCode(String orderCode) {
        return orderRepository.findByOrderCode(orderCode);
    }
}