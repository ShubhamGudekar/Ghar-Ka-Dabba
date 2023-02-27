package com.app.service;

import java.util.List;

import com.app.dto.OrderDto;
import com.app.dto.OrderResponseDto;
import com.app.dto.OrderStatusDto;
import com.app.entities.Order;

public interface OrderService {

	List<OrderResponseDto> getAllOrderDetails();

	OrderResponseDto getOrderDetailsById(Long id);

	List<Order> getAllOrdersByCustomerId(Long id);

	String addNewOrder(OrderDto ordersDto);

	String updateOrderStatus(OrderStatusDto ordersDto);
	
}
