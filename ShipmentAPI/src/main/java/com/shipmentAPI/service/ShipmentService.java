package com.shipmentAPI.service;

import java.util.List;

import com.shipmentAPI.entity.Shipment;

public interface ShipmentService {
	
	public List<Shipment> getLoads();

	public Shipment getByShipperId(long shipperId);

	public Shipment addLoad(Shipment load);

	public void updateLoadById(long shipperId, Shipment load);

	public void delete(long shipperId);
}
