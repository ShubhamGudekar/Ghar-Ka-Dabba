package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CustomerPlanDto;
import com.app.dto.SubscriptionPlanDto;
import com.app.entities.CustomerPlanSubscription;
import com.app.entities.SubscriptionPlan;
import com.app.repository.CustomerPlanRepository;
import com.app.repository.SubscriptionRepository;

@Service
@Transactional
public class CustomerPlanServcImpl implements CustomerPlanService {
	
//	@Autowired
//	private SubscriptionRepository subscriptionrepo;
	
	@Autowired
	private CustomerPlanRepository customerplanrepo;
	
	@Autowired	
	private ModelMapper mapper;
	
	//add new customer plan
	@Override
	public CustomerPlanDto addNewCustomerPlan(CustomerPlanDto CustomerPlanDto) {
		CustomerPlanSubscription customerplansubscription=new CustomerPlanSubscription(CustomerPlanDto.getStartDate().toString(),CustomerPlanDto.getEndDate().toString());
		CustomerPlanSubscription newcustomerplansubscription=customerplanrepo.save(customerplansubscription);
		// TODO Auto-generated method stub
		return mapper.map(newcustomerplansubscription,CustomerPlanDto.class);
	}

	//get all customer plans
	@Override
	public List<CustomerPlanDto> getAllCustomerPlans() {
		// TODO Auto-generated method stub
		return customerplanrepo.findAll().stream().map(customer -> mapper.map(customer, CustomerPlanDto.class))
				.collect(Collectors.toList());		
	}

	//get an customer plan by id 
	@Override
	public CustomerPlanDto getCustomerPlanById(long id) {
		// TODO Auto-generated method stub
		CustomerPlanSubscription CustomerPlanSubscription = customerplanrepo.findById(id).orElseThrow();
		return mapper.map(CustomerPlanSubscription, CustomerPlanDto.class);
	}

	//remove a customer plan
	@Override
	public String removeCustomerPlanDto(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	//edit an customer plan
	@Override
	public String editCustomerPlanDetails(CustomerPlanDto CustomerPlanDto) {
		// TODO Auto-generated method stub
		CustomerPlanSubscription CustomerPlanSubscription = customerplanrepo.findById(CustomerPlanDto.getId()).orElseThrow();
        CustomerPlanSubscription.setStartDate(CustomerPlanDto.getStartDate());
        CustomerPlanSubscription.setEndDate(CustomerPlanDto.getEndDate());
		return "customer plan updated successfully!";
//		private LocalDate startDate;
//		
//		private LocalDate endDate;		
	}

	//get individual customer plan by subscription id
	@Override
	public CustomerPlanDto getCustomerPlanBySubscriptionId(long id) {
		// TODO Auto-generated method stub
//		CustomerPlanSubscription customerplansubscription=
		return null;
	}

}
