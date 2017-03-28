package com.pluralsight.service;

import java.util.List;

import com.pluralsight.model.Attendee;

public interface AttendeeService {
	Attendee save(Attendee attendee);
	List<Attendee> getAll();
	Attendee getAttendee(Long id);
}
