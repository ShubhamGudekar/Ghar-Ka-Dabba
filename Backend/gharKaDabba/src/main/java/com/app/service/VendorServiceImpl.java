package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Vendor;
import com.app.repository.VendorRepository;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepo;

	@Override
	public String approveVendor(long id) {
		Vendor vendor = vendorRepo.findById(id).orElseThrow();
		vendor.setVerified(true);
		return "Vendor Approved Successfully";
	}

	@Override
	public List<Vendor> getAllUser() {

		return vendorRepo.findAll();
	}

	@Override
	public Vendor getVendorById(long id) {

		return vendorRepo.findById(id).orElseThrow();
	}

}
