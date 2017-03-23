package com.pluralsight.service;

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

}
