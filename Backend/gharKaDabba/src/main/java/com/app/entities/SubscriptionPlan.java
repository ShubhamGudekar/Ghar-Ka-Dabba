package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.enums.PlanType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="subscription_plans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionPlan extends BaseEntity{
	
	private String name;
	
	private String description;
	
	private double price;
	
	@Enumerated(EnumType.STRING)
	private PlanType planType;
	
	@ElementCollection
	@JoinTable(name="plan_tiffins")
	@Column(name="subcription_id")
	private Set<Tiffin> tiffins = new HashSet<Tiffin>();
	
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor ;
	
	@OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CustomerPlanSubscription> plans = new HashSet<CustomerPlanSubscription>();
	
	@ManyToMany(mappedBy = "plans")
	private Set<Order> orders = new HashSet<Order>();
	
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;
}
