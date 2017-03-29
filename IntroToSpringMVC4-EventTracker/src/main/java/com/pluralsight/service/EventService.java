package com.pluralsight.service;

import java.util.List;

import com.pluralsight.model.Event;
import com.pluralsight.model.EventReport;

public interface EventService {
	Event save(Event event);
	List<Event> getAll();
	List<EventReport> getAllEventReports();
	Event getEvent(Long id);
}
