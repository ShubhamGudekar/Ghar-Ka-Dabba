package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class User extends BaseEntity {

	@Column(length = 50)
	private String fisrtName;

	@Column(length = 50)
	private String lastName;

	@Column(length = 50,unique = true)
	private String email;

	@Column(length = 10,unique = true)
	private String mobile;

	@Column(length = 12)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Role userRole;

	@CreationTimestamp
	private LocalDateTime registerDate;

}
