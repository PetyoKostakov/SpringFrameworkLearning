package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Event;
import com.pluralsight.model.EventReport;

@Repository("aventRepository")
public class EventRepositoryImpl implements EventRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public Event save(Event event) {
		em.persist(event);
		return event;
	}

	@Override
	public List<Event> getAll() {
		//Query query = em.createQuery("SELECT e FROM Event e");
		TypedQuery<Event> query = em.createNamedQuery(Event.FIND_ALL_EVENTS, Event.class);
		
	    return (List<Event>) query.getResultList();
	}
	
	public Event getEvent(Long id) {
		 return em.find(Event.class, id);
	}
	

	@Override
	public List<EventReport> getAllEventReports() {
		//Query query = em.createQuery("Select new com.pluralsight.model.EventReport(g.name, e.id)" + 
		//							"from Event g, Attendee e where g.id = e.event.id");

		TypedQuery<EventReport> query = em.createNamedQuery(Event.FIND_EVENT_REPORTS, EventReport.class);

		return query.getResultList();
	}
}
