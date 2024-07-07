package com.techrevamp.controllers;

import com.techrevamp.models.Payment;
import com.techrevamp.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Endpoint para obtener todos los pagos
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Endpoint para obtener un pago por su ID
    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para crear un nuevo pago
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPayment);
    }

    // Endpoint para actualizar un pago existente
    @PutMapping("/{paymentId}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long paymentId, @RequestBody Payment payment) {
        Payment updatedPayment = paymentService.updatePayment(paymentId, payment);
        if (updatedPayment != null) {
            return ResponseEntity.ok(updatedPayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar un pago por su ID
    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) {
        paymentService.deletePayment(paymentId);
        return ResponseEntity.noContent().build();
    }
}
