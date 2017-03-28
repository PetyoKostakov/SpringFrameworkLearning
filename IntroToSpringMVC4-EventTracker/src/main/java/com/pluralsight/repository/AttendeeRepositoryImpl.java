package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Attendee;

@Repository("attendeeRepository")
public class AttendeeRepositoryImpl implements AttendeeRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public Attendee save(Attendee attendee) {
		em.persist(attendee);
		return attendee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attendee> getAll() {
		Query query = em.createQuery("SELECT e FROM Attendee e");
	    return (List<Attendee>) query.getResultList();
	}
	
	public Attendee getAttendee(Long id) {
		 return em.find(Attendee.class, id);
	}
}
