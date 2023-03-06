package com.app.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.AddressDto;
import com.app.dto.CustDetailsDto;
import com.app.dto.EditUserDetailsDto;
import com.app.dto.SubscriptionPlanDto;

public interface CustomerService {

	List<CustDetailsDto> getAllCustomers();

	CustDetailsDto getCustomerById(long id);

	String removeCustomer(long id);

	String editCustomerDetails(EditUserDetailsDto detailsDto);

	String uploadImage(Long id, MultipartFile imageFile) throws IOException;

	byte[] getImage(Long id) throws IOException;

	String addDeliveryAddress(AddressDto address, Long id);

	List<AddressDto> getDeliveryAddress(Long id);

	String updateDeliveryAddress(Set<AddressDto> addressDto, Long id);

	List<SubscriptionPlanDto> getSubscriptionPlans(Long id);

	CustDetailsDto getByEmail(String email);

}
