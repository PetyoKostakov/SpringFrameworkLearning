package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Event {
	
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(mappedBy="event", cascade=CascadeType.ALL)
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
