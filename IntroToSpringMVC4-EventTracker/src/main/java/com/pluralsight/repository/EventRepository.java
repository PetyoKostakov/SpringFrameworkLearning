package com.pluralsight.repository;

import java.util.List;

import com.pluralsight.model.Event;
import com.pluralsight.model.EventReport;

public interface EventRepository {
	Event save(Event event);
	List<Event> getAll();
	public List<EventReport> getAllEventReports();
	Event getEvent(Long id);
}
