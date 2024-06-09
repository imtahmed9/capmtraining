package com.capmtraining.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Entity
@Table(name="VENDOR")
public class Vendor {

	@Id
	@Column(nullable = false, name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id; 
	@Column(nullable = false, name="COMPANY_NAME")
	public String companyName; 
	@Column(nullable = false, name="FIRST_NAME")
	public String firstName; 
	@Column(nullable = false, name="LAST_NAME")
	public String lastName; 
	@Column(nullable = false, name="WEBSITE")
	public String website; 
	@Column(nullable = false, name="EMAIL")
	public String email; 
	@Column(nullable = false, name="STATUS")
	public String status; 
	@Column(nullable = false, name="GST_NO")
	public String gstNo;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="Vendor", referencedColumnName="ID")
	public List<Address> addresses = new ArrayList<>();
	
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


	public List<Address> getAddresses() {
		return addresses;
	}





	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}





	public Vendor(Long id, String companyName, String firstName, String lastName, String website, String email,
			String status, String gstNo, List<Address> addresses) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.website = website;
		this.email = email;
		this.status = status;
		this.gstNo = gstNo;
		this.addresses = addresses;
	}





	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	
	
	
	
	

}
