package com.shipmentAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shipmentAPI.entity.Shipment;
import com.shipmentAPI.service.ShipmentService;

@RestController
public class ShipmentController {
	
	@Autowired
	ShipmentService service;
	
	@GetMapping("/load")
	public List<Shipment> getLoad() {
		return service.getLoads();
	}
	
	@GetMapping("/load/{shipperId}")
	public Shipment getByID(@PathVariable String shipperId) {
		return this.service.getByShipperId(Long.parseLong(shipperId));
	}
	
	@PostMapping("/load")
	public Shipment addLoad(@RequestBody Shipment load) {
		return this.service.addLoad(load);
	}
	
	@PutMapping("load/{shipperId}")
	public String putMethodName(@PathVariable String shipperId, @RequestBody Shipment load) {
		this.service.updateLoadById(Long.parseLong(shipperId), load);
		return "Updated";
	}
	
	@DeleteMapping("load/{shipperId}")
	public String deleteLoad(@PathVariable String shipperId) {
		this.service.delete(Long.parseLong(shipperId));
		return "Deleted";
	}
}
