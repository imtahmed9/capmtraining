package com.capmtraining.controller;

import java.lang.StackWalker.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.capmtraining.entities.Vendor;
import com.capmtraining.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	VendorService vendorService;
	
	@RequestMapping("/Vendor")
	public List<Vendor> getVendors() {
		return vendorService.readAllVendors();
		
	}

	@RequestMapping("/Vendor/{code}")
	public Vendor getVendorById(@PathVariable("code") Long code) {
		Optional<Vendor> searchResult = vendorService.getSingleVendor(code);
		if(!searchResult.isPresent()) {
			return new Vendor((long)0, "", "", "", "", "", "", null, null);
		}
		return searchResult.get();
	}
	
	@PostMapping("/Vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) {
		return vendorService.createVendor(myPostBody);
	}
	
	@RequestMapping("/Vendor/search")
	public List<Vendor> searchByCompanyName(@RequestParam String companyName) {
		return vendorService.searchByCompanyName(companyName);
	}
	
	@RequestMapping("/Vendor/lookup")
	public List<Vendor> searchByGSTNo(@RequestParam String GSTno) {
		return vendorService.lookUpVendorByGST(GSTno);
	}
	
	public Vendor emptyVendor() {
			return new Vendor((long)0, "", "", "", "", "", "", null, null);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/changeVender")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		Optional<Vendor> myVendor = vendorService.getSingleVendor(vendor.getId());
		if(!myVendor.isPresent()) {
			return new Vendor((long)0, "", "", "", "", "", "", null, null);
		}

		return vendorService.updateVendor(vendor);
	}
//	
	@RequestMapping(method=RequestMethod.DELETE, value="/Vendor/{id}")
	public String deleteVendor(@PathVariable("id") Long id) {
		return vendorService.deleteVendor(id);
	}
	
}
