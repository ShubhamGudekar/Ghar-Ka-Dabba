package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.app.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class UserEntity extends BaseEntity {

	@Column(length = 50)
	private String firstName;

	@Column(length = 50)
	private String lastName;

	@Column(length = 50,unique = true)
	private String email;

	@Column(length = 10,unique = true)
	private String mobile;

	@Column(length = 300)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private UserRole userRole;

	@CreationTimestamp
	private LocalDateTime registerDate;

	private String profileImage;
}
