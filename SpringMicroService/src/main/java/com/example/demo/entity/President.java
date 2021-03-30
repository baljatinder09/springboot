package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class President {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRESIDENT_ID")
	private Long id;
	
	@Column(name="MIDDLE_INITIAL")
	private String middleInitial;
	
	@NotEmpty(message="Please provide the firstName")
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@NotEmpty(message="Please provide the lastName")
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@NotEmpty(message="Please provide the email")
	@Column(name = "EMAIL_ADDRESS")
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	

}
