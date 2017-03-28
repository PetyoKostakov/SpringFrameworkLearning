package com.pluralsight.repository;

import java.util.List;

import com.pluralsight.model.Attendee;

public interface AttendeeRepository {
	Attendee save(Attendee attendee);
	List<Attendee> getAll();
	Attendee getAttendee(Long id);
}
