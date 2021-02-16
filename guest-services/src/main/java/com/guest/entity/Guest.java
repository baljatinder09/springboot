package com.guest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GUEST")
public class Guest {
			  
			  @Column(name="GUEST_ID")
			  @Id
			  @GeneratedValue(strategy=GenerationType.AUTO)
			  private Long id;
			  
			  @Column(name="FIRST_NAME")
			  private String firstName;
			  
			  @Column(name="LAST_NAME")
			  private String lastName;
			  
			  @Column(name="EMAIL_ADDRESS")
			  private String email;
			  
			  @Column(name="ADDRESS")
			  private String address;
			  
			  @Column(name="COUNTRY")
			  private String country;
			  
			  @Column(name="STATE")
			  private String state;
			  
			  @Column(name="PHONE_NUMBER")
			  private String phoneNumber;

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

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

			public String getAddress() {
				return address;
			}

			public void setAddress(String address) {
				this.address = address;
			}

			public String getCountry() {
				return country;
			}

			public void setCountry(String country) {
				this.country = country;
			}

			public String getState() {
				return state;
			}

			public void setState(String state) {
				this.state = state;
			}

			public String getPhoneNumber() {
				return phoneNumber;
			}

			public void setPhoneNumber(String phoneNumber) {
				this.phoneNumber = phoneNumber;
			}  

}
