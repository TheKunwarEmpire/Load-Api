package com.shipmentAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shipmentAPI.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

	Shipment findByShipperId(long shipperId);

}
