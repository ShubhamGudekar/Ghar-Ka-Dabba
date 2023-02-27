package com.app.dto;

import java.time.LocalDateTime;
import java.util.HashSet;

import com.app.entities.Customer;
import com.app.entities.SubscriptionPlan;
import com.app.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {

	private OrderStatus status;
	
	private LocalDateTime dateTime;
	
	private Customer customerId;
	
	private double paymentAmount;
	
	private HashSet<SubscriptionPlan> plans;
	
}
