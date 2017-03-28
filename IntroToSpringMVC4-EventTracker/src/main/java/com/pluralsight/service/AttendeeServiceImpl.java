package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Attendee;
import com.pluralsight.repository.AttendeeRepository;

@Service("attendeeService")
public class AttendeeServiceImpl implements AttendeeService {
	@Autowired
	private AttendeeRepository attendeeRepo;
	
	@Override
	public Attendee save(Attendee attendee) {
		attendeeRepo.save(attendee);
		return attendee;
	}

	@Override
	public List<Attendee> getAll() {
		return attendeeRepo.getAll();
	}
	
	public Attendee getAttendee(Long id) {
		return attendeeRepo.getAttendee(id);
	}

}
