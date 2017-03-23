package com.pluralsight.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
