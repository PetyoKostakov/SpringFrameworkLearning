package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Event;
import com.pluralsight.model.EventReport;
import com.pluralsight.repository.EventRepository;

@Service("eventService")
public class EventServiceImpl implements EventService {
	@Autowired
	private EventRepository eventRepo;
	
	@Override
	public Event save(Event event) {
		eventRepo.save(event);
		return event;
	}

	@Override
	public List<Event> getAll() {
		return eventRepo.getAll();
	}
	
	public Event getEvent(Long id) {
		return eventRepo.getEvent(id);
	}

	@Override
	public List<EventReport> getAllEventReports() {
		return eventRepo.getAllEventReports();
	}
}
