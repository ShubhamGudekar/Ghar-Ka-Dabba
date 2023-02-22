package com.app.service;

import java.util.List;

import com.app.entities.Vendor;

public interface VendorService {

	String approveVendor(long id);

	List<Vendor> getAllUser();

	Vendor getVendorById(long id);
	
}
