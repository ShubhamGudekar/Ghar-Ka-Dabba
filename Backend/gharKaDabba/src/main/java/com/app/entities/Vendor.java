package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vendors")
@Getter
@Setter
@NoArgsConstructor
public class Vendor extends UserEntity {

	private boolean isVerified;

	public Vendor(String firstName, String lastName, String email, String mobile) {
		super(firstName, lastName, email, mobile);

	}
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<SubscriptionPlan> plans = new HashSet<SubscriptionPlan>();


}
