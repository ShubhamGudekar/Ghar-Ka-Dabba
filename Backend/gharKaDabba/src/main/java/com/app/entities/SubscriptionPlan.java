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
public class SubscriptionPlan extends BaseEntity{
	
	private String name;
	
	private String description;
	
	private double price;
	
	public SubscriptionPlan(String name, String description, double price, PlanType planType) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.planType = planType;
	}

	@Enumerated(EnumType.STRING)
	private PlanType planType;
	
	@ElementCollection
	@JoinTable(name="plan_tiffins")
	@Column(name="subcription_id")
	private Set<Tiffin> tiffins = new HashSet<Tiffin>();
	
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;
	
	@OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CustomerPlanSubscription> plans = new HashSet<CustomerPlanSubscription>();
	
	@ManyToMany(mappedBy = "plans")
	private Set<Order> orders = new HashSet<Order>();
	
}