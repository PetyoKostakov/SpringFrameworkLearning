package com.pluralsight.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.pluralsight.view.Phone;

//@Table(name="ATTENDEE")
@Entity
public class Attendee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	//@Column(name="NAME")
	@Size(min=2, max=30) 
	private String name;
	
	@Email
	private String emailAddress;
	//private Event event;
	
	@NotEmpty
	@Phone
	private String phone;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
