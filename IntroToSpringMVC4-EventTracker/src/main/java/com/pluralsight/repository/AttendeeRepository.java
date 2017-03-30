package com.pluralsight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pluralsight.model.Attendee;

@Repository("attendeeRepository")
public interface AttendeeRepository extends JpaRepository<Attendee, Long>{
	/*Attendee save(Attendee attendee);
	List<Attendee> getAll();
	Attendee getAttendee(Long id);*/
}
