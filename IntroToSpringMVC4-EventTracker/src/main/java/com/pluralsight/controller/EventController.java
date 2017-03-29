package com.pluralsight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pluralsight.model.Event;
import com.pluralsight.model.EventReport;
import com.pluralsight.service.EventService;

@Controller
@SessionAttributes("event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	/* PAGES */
	
	@RequestMapping(value="/event", method=RequestMethod.GET)
	public String displayEventPage(Model model) {
		System.out.println("/event");
		Event event = new Event();
		
		event.setName("Java User group");
		model.addAttribute("event", event);
		
		return "event";
	}
	
	@RequestMapping(value="/eventList", method=RequestMethod.GET)
	public String displayEventListPage(Model model) {
		System.out.println("/eventList");
		List<Event> events = eventService.getAll();
		
		model.addAttribute("events", events);
		
		return "eventList";
	}
	
	@RequestMapping(value="/event", method=RequestMethod.POST)
	public String processAttendee(@Valid Event event, BindingResult result, Model m) {
		System.out.println("/event - POST");
		
		if (result.hasErrors()) {
			return "event";
		} else {
			eventService.save(event);
		}
		
		return "redirect:index.html";
	}
	
	@RequestMapping(value="/eventReport", method=RequestMethod.GET)
	public String processEventReport(Model model) {
		System.out.println("/eventReport - GET");
		
		List<EventReport> eventReports = eventService.getAllEventReports();
		model.addAttribute("eventReports", eventReports);
		
		return "eventReport";
	}
	
	/* REST SERVICES*/
	
	@RequestMapping(value = "/api/event", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> listAllAEvents() {
        List<Event> events = eventService.getAll();
        if(events.isEmpty()){
            return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/event/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> getEvent(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Event event = eventService.getEvent(id);
        if (event == null) {
            System.out.println("Event with id " + id + " not found");
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }
}
