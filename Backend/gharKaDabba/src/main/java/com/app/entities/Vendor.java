package com.app.entities;

import javax.persistence.Entity;
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

}
