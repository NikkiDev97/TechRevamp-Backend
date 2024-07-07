package com.techrevamp.repositories;

import com.techrevamp.models.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {
}
