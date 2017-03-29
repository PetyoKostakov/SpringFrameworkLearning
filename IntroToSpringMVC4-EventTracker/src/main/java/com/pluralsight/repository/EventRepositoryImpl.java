package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Event;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getAll() {
		Query query = em.createQuery("SELECT e FROM Event e");
	    return (List<Event>) query.getResultList();
	}
	
	public Event getEvent(Long id) {
		 return em.find(Event.class, id);
	}
}
