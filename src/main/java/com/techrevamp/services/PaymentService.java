package com.techrevamp.services;

import com.techrevamp.models.Payment;
import com.techrevamp.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Método para obtener todos los pagos
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Método para obtener un pago por su ID
    public Payment getPaymentById(Long paymentId) {
        Optional<Payment> paymentOptional = paymentRepository.findById(paymentId);
        return paymentOptional.orElse(null);
    }

    // Método para crear un nuevo pago
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Método para actualizar un pago existente
    public Payment updatePayment(Long paymentId, Payment payment) {
        Optional<Payment> paymentOptional = paymentRepository.findById(paymentId);
        if (paymentOptional.isPresent()) {
            Payment existingPayment = paymentOptional.get();
            existingPayment.setOrder(payment.getOrder());
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setPaymentMethod(payment.getPaymentMethod());
            return paymentRepository.save(existingPayment);
        }
        return null;
    }

    // Método para eliminar un pago por su ID
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
