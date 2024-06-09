package com.capmtraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capmtraining.entities.Address;
import com.capmtraining.service.AddressService;
import com.capmtraining.service.IAddressPresistence;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addSrv;
	
	@RequestMapping("/Address")
	public List<Address> getAddress() {
		return addSrv.getAllAddress();
	}
	
	@PostMapping("/Address") 
	public Address createAddress(@RequestBody Address payload) {
		return addSrv.saveAddress(payload);
	}
}
