package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer extends UserEntity {

	public Customer(String firstName, String lastName, String email, String mobile) {
		super(firstName, lastName, email, mobile);

	}

	@ElementCollection
	@CollectionTable(name = "delivery_addresses")
	@Column(name = "cust_id")
	private Set<Address> deliveryAddress = new HashSet<Address>();

	@OneToOne(mappedBy = "customer")
	private Order order;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CustomerPlanSubscription> plans = new HashSet<>();

	@OneToOne(mappedBy = "cartOwner", cascade = CascadeType.ALL, orphanRemoval = true)
	private Cart cart;

}
