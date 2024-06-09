package com.capmtraining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capmtraining.entities.Address;

@Component
public class AddressService {
	@Autowired
	IAddressPresistence address;
	
	public List<Address> getAllAddress() {
		return address.findAll();
	}
	
	public Address saveAddress(Address payload) {
		return address.save(payload);
	}
}
