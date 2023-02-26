package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dto.CustomerPlanDto;
import com.app.dto.SubscriptionPlanDto;
import com.app.entities.CustomerPlanSubscription;
import com.app.entities.SubscriptionPlan;
import com.app.repository.CustomerPlanRepository;
import com.app.repository.SubscriptionRepository;

public class CustomerPlanServcImpl implements CustomerPlanService {
	
	@Autowired
	private SubscriptionRepository subscriptionrepo;
	
	@Autowired
	private CustomerPlanRepository customerplanrepo;
	
	@Autowired	
	private ModelMapper mapper;
	
	@Override
	public CustomerPlanDto addNewCustomerPlan(CustomerPlanDto CustomerPlanDto) {
		CustomerPlanSubscription customerplansubscription=new CustomerPlanSubscription(CustomerPlanDto.getStartDate().toString(),CustomerPlanDto.getEndDate().toString());
		customerplanrepo.save(customerplansubscription);
		// TODO Auto-generated method stub
		return mapper.map(customerplansubscription,CustomerPlanDto.class);
	}

	@Override
	public List<CustomerPlanDto> getAllCustomerPlans() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public CustomerPlanDto getCustomerPlanById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeCustomerPlanDto(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editCustomerPlanDetails(CustomerPlanDto CustomerPlanDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerPlanDto getCustomerPlanBySubscriptionId(long id) {
		// TODO Auto-generated method stub
//		CustomerPlanSubscription customerplansubscription=
		return null;
	}

}
