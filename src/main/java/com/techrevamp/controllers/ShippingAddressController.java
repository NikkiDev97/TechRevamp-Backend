package com.techrevamp.controllers;

import com.techrevamp.models.ShippingAddress;
import com.techrevamp.services.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shipping-addresses")
public class ShippingAddressController {

    @Autowired
    private ShippingAddressService shippingAddressService;


    // Endpoint para obtener todas las direcciones de envío
    @GetMapping
    public List<ShippingAddress> getAllShippingAddresses() {
        return shippingAddressService.getAllShippingAddresses();
    }

    // Endpoint para obtener una dirección de envío por su ID
    @GetMapping("/{addressId}")
    public ShippingAddress getShippingAddressById(@PathVariable Long addressId) {
        return shippingAddressService.getShippingAddressById(addressId);
    }

    // Endpoint para crear una nueva dirección de envío
    @PostMapping
    public ShippingAddress createShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        return shippingAddressService.createShippingAddress(shippingAddress);
    }

    // Endpoint para actualizar una dirección de envío existente
    @PutMapping("/{addressId}")
    public ShippingAddress updateShippingAddress(@PathVariable Long addressId, @RequestBody ShippingAddress shippingAddress) {
        return shippingAddressService.updateShippingAddress(addressId, shippingAddress);
    }

    // Endpoint para eliminar una dirección de envío por su ID
    @DeleteMapping("/{addressId}")
    public void deleteShippingAddress(@PathVariable Long addressId) {
        shippingAddressService.deleteShippingAddress(addressId);
    }
}
