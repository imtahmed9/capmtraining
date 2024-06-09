package com.capmtraining.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capmtraining.entities.Vendor;
import java.util.List;


public interface IvendorPersistence extends JpaRepository<Vendor, Long> {
	List<Vendor> findByCompanyName(String companyName);
	
	@Query(nativeQuery = true, 
			value="SELECT * FROM public.vendor where lower(GST_NO) like %?1%")
	List<Vendor> lookUpVendorByGST(String GSTNo);
}
