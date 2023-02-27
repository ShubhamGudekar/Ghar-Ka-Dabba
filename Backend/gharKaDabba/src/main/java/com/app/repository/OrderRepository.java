package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Customer;
import com.app.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByCustomer(Customer customer);
	
}
