package com.techrevamp.services;

import com.techrevamp.models.ShippingAddress;
import com.techrevamp.repositories.ShippingAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingAddressService {

    private final ShippingAddressRepository shippingAddressRepository;

    @Autowired
    public ShippingAddressService(ShippingAddressRepository shippingAddressRepository) {
        this.shippingAddressRepository = shippingAddressRepository;
    }

    // Método para obtener todas las direcciones de envío
    public List<ShippingAddress> getAllShippingAddresses() {
        return shippingAddressRepository.findAll();
    }

    // Método para obtener una dirección de envío por su ID
    public ShippingAddress getShippingAddressById(Long addressId) {
        Optional<ShippingAddress> addressOptional = shippingAddressRepository.findById(addressId);
        return addressOptional.orElse(null);
    }

    // Método para crear una nueva dirección de envío
    public ShippingAddress createShippingAddress(ShippingAddress shippingAddress) {
        return shippingAddressRepository.save(shippingAddress);
    }

    // Método para actualizar una dirección de envío existente
    public ShippingAddress updateShippingAddress(Long addressId, ShippingAddress updatedAddress) {
        Optional<ShippingAddress> addressOptional = shippingAddressRepository.findById(addressId);
        if (addressOptional.isPresent()) {
            ShippingAddress existingAddress = addressOptional.get();
            existingAddress.setUser(updatedAddress.getUser());
            existingAddress.setStreet(updatedAddress.getStreet());
            existingAddress.setCity(updatedAddress.getCity());
            existingAddress.setState(updatedAddress.getState());
            existingAddress.setPostalCode(updatedAddress.getPostalCode());
            existingAddress.setCountry(updatedAddress.getCountry());
            return shippingAddressRepository.save(existingAddress);
        }
        return null;
    }

    // Método para eliminar una dirección de envío por su ID
    public void deleteShippingAddress(Long addressId) {
        shippingAddressRepository.deleteById(addressId);
    }
}
