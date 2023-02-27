package com.app.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.app.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity{

	private int quantity;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@CreationTimestamp
	private LocalDateTime dateTime;
	
	private String feedback;
	
	private String imagePath;
	
	@OneToOne(mappedBy = "order")
	private Payment payment;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToMany
	@JoinTable(name = "plan_orders", joinColumns = @JoinColumn(name = "subcription_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private Set<SubscriptionPlan> plans = new HashSet<>();
	
	public Order(OrderStatus status, Customer customer, Set<SubscriptionPlan> plans) {
		super();
		this.status = status;
		this.customer = customer;
		this.plans = plans;
	}
}
