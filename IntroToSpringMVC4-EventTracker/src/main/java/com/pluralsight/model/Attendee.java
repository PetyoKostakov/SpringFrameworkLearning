package com.pluralsight.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pluralsight.view.Phone;

//@Table(name="ATTENDEE")
@Entity
public class Attendee {

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonBackReference // stackoverflow exeption http://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
	private Event event;
	
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
	
	public Event getEvent() {
		return event;
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
	public void setEvent(Event event) {
		this.event = event;
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
