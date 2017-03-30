package com.pluralsight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pluralsight.model.Event;
import com.pluralsight.model.EventReport;

public interface EventRepository extends JpaRepository<Event, Long> {
	@Query("Select new com.pluralsight.model.EventReport(g.name, e.id)" + 
			"from Event g, Attendee e where g.id = e.event.id")
	public List<EventReport> getAllEventReports();
}
