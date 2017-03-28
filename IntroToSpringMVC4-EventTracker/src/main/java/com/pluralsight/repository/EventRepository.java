package com.pluralsight.repository;

import java.util.List;

import com.pluralsight.model.Event;

public interface EventRepository {
	Event save(Event event);
	List<Event> getAll();
	Event getEvent(Long id);
}
