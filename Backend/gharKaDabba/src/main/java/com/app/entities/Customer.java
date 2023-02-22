package com.app.entities;

import javax.persistence.Entity;
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


	
	
}
