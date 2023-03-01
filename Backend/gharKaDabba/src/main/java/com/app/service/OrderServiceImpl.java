package com.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.OrderDto;
import com.app.dto.OrderResponseDto;
import com.app.dto.OrderStatusDto;
import com.app.entities.Customer;
import com.app.entities.Order;
import com.app.entities.SubscriptionPlan;
import com.app.enums.OrderStatus;
import com.app.repository.CustomerRepository;
import com.app.repository.OrderRepository;
import com.app.repository.SubscriptionPlanRepository;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private SubscriptionPlanRepository subscriptionRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<OrderResponseDto> getAllOrderDetails() {
		List<Order> orders = orderRepo.findAll();
		return orders.stream().map(o -> mapper.map(o, OrderResponseDto.class)).collect(Collectors.toList());
	}

	@Override
	public OrderResponseDto getOrderDetailsById(Long id) {
		Order order = orderRepo.findById(id).orElseThrow();
		System.out.println(order);
		OrderResponseDto responseDto =mapper.map(order, OrderResponseDto.class);
//		Customer customer = orderRepo.findB
//		responseDto.setCustomerId();
		return responseDto;
	}

	@Override
	public List<Order> getAllOrdersByCustomerId(Long id) {
		Customer customer = custRepo.findById(id).orElseThrow();
		customer.getDeliveryAddress();
		return customer.getOrders().stream().collect(Collectors.toList());
	}

	@Override
	public String addNewOrder(OrderDto ordersDto) {
		Customer customer = custRepo.findById(ordersDto.getCustomerId()).orElseThrow();
		SubscriptionPlan subscriptionPlan = subscriptionRepo.findById(ordersDto.getSubscriptionId()).orElseThrow();
		Set<SubscriptionPlan> plans = new HashSet<SubscriptionPlan>();
		plans.add(subscriptionPlan);
		Order order = new Order(OrderStatus.PENDING, customer, plans);
		order = orderRepo.save(order);
		return "Order Placed Successfully with Order Id : " + order.getId();
	}

	@Override
	public String updateOrderStatus(OrderStatusDto orderDto) {
		Order order = orderRepo.findById(orderDto.getOrdereId()).orElseThrow();
		order.setStatus(orderDto.getStatus());
		return "Order Status Updated Successfully";
	}

}
