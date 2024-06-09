package com.capmtraining.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capmtraining.entities.Vendor;

@Component
public class VendorService {
	
	@Autowired
	IvendorPersistence vendor;

	
	public List<Vendor> readAllVendors() {
		return vendor.findAll();
	}
	
	public Optional<Vendor> getSingleVendor(Long code ) {
		return vendor.findById(code);
	}
	
	public Vendor updateVendor(Vendor vendorObj) {
		return vendor.save(vendorObj);
	}
	
	public String deleteVendor(Long vendorId ) {
		vendor.deleteById(vendorId);
		return "Deleted Successfully";
	}
	
	public List<Vendor> searchByCompanyName(String companyName) {
		return vendor.findByCompanyName(companyName);
	}
	
	public Vendor createVendor(Vendor vendorObj ) {
		return vendor.save(vendorObj);
	}

	public List<Vendor> lookUpVendorByGST(String gSTno) {
		return vendor.lookUpVendorByGST(gSTno);
	}

	
	 
}
