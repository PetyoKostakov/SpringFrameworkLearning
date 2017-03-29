package com.pluralsight.model;

// Projection class used in named query
public class EventReport {
	private String eventName;
	private Long id;
	
	public EventReport(String eventName) {
		this.eventName = eventName;
	}

	public EventReport(String eventName, Long id) {
		this.eventName = eventName;
		this.id = id;
	}
	

	public String getEventName() {
		return eventName;
	}


	public Long getId() {
		return id;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
