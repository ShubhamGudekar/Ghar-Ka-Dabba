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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.app.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@JsonManagedReference
	@ManyToMany
	@JoinTable(name = "plan_orders", joinColumns = @JoinColumn(name = "subcription_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private Set<SubscriptionPlan> plans = new HashSet<>();
	
	public Order(OrderStatus status, Customer customer, Set<SubscriptionPlan> plans) {
		super();
		this.status = status;
		this.customer = customer;
		this.plans = plans;
	}

	@Override
	public String toString() {
		return "Order [quantity=" + quantity + ", status=" + status + ", dateTime=" + dateTime + ", feedback="
				+ feedback + ", imagePath=" + imagePath + ", payment=" + payment + ", customer=" + customer + ", plans="
				+ plans + "]";
	}
	
	
}
