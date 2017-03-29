package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Event {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy="event", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonManagedReference // stackoverflow exeption http://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
	private List<Attendee> attendees = new ArrayList<Attendee>();
	private String name;

	public List<Attendee> getAttendees() {
		return attendees;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void addAttende(Attendee attendee) {
		this.attendees.add(attendee);
	}

	public void setAttendees(List<Attendee> attendees) {
		this.attendees = attendees;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
