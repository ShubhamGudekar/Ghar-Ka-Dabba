package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

//	@Query("select c from Customer c join fetch c.deliveryAddress")
//	List<Customer> getAllCustomers();
}
