package com.pluralsight.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pluralsight.model.Attendee;
import com.pluralsight.model.Event;
import com.pluralsight.service.AttendeeService;
import com.pluralsight.service.EventService;

@Controller
public class TestController {
	@Autowired
	private AttendeeService attendeeService;
	@Autowired
	private EventService eventService;
	
	
	@RequestMapping(value="/test/createEvent", method=RequestMethod.GET)
	public ResponseEntity<Event> createEvent() {
		Event event = new Event();
		event.setName("Event name - test");
		//eventService.save(event);
		
		Attendee attendee = new Attendee();
		attendee.setName("Gosho");
		attendee.setEmailAddress("test@test.com");
		attendee.setPhone("123");
		attendee.setEvent(event);
		attendeeService.save(attendee);
		
		Attendee attendee1 = new Attendee();
		attendee1.setName("Gosho1");
		attendee1.setEmailAddress("test1@test.com");
		attendee1.setPhone("1231");
		attendee1.setEvent(event);
		attendeeService.save(attendee1);
		
		eventService.save(event);
		
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
}
