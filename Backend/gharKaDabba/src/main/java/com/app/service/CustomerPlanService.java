package com.app.service;

import java.util.List;

import com.app.dto.CustomerPlanDto;
import com.app.dto.SubscriptionPlanDto;

public interface CustomerPlanService {
	CustomerPlanDto addNewCustomerPlan(CustomerPlanDto CustomerPlanDto);

	List<CustomerPlanDto> getAllCustomerPlans();

	CustomerPlanDto getCustomerPlanById(long id);

	String removeCustomerPlanDto(long id);

	String editCustomerPlanDetails(CustomerPlanDto CustomerPlanDto);
	
	CustomerPlanDto getCustomerPlanBySubscriptionId(long id);

}
