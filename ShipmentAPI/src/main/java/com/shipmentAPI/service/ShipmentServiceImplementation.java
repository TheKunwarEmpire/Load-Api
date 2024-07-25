package com.shipmentAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipmentAPI.entity.Shipment;
import com.shipmentAPI.repository.ShipmentRepository;

@Service
public class ShipmentServiceImplementation implements ShipmentService {
	
	@Autowired
	ShipmentRepository repo;
	
	@Override
	public List<Shipment> getLoads() {
		return repo.findAll();
	}
	@Override
	public Shipment getByShipperId(long shipperId) {
		return repo.findByShipperId(shipperId);
	}
	@Override
	public Shipment addLoad(Shipment load) {
		repo.save(load);
		return load;
	}
	@Override
	public void updateLoadById(long shipperId, Shipment updatedShipment) {
		Optional<Shipment> shipmentOptional = repo.findById(shipperId);
        
        if (shipmentOptional.isPresent()) {
            Shipment existingShipment = shipmentOptional.get();
            
            existingShipment.setLoadingPoint(updatedShipment.getLoadingPoint());
            existingShipment.setUnloadingPoint(updatedShipment.getUnloadingPoint());
            existingShipment.setProductType(updatedShipment.getProductType());
            existingShipment.setTruckType(updatedShipment.getTruckType());
            existingShipment.setNoOfTrucks(updatedShipment.getNoOfTrucks());
            existingShipment.setWeight(updatedShipment.getWeight());
            existingShipment.setDate(updatedShipment.getDate());
            
            repo.save(existingShipment);
        }
		
	}
	@Override
	public void delete(long shipperId) {
		repo.deleteById(shipperId);
	}
}
