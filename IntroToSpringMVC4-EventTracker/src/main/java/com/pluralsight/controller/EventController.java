package com.pluralsight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pluralsight.model.Event;
import com.pluralsight.service.EventService;

@Controller
@SessionAttributes("event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value="/event", method=RequestMethod.GET)
	public String displayEventPage(Model model) {
		System.out.println("/event");
		Event event = new Event();
		
		event.setName("Java User group");
		model.addAttribute("event", event);
		
		return "event";
	}
	
	@RequestMapping(value="/event", method=RequestMethod.POST)
	public String processEvent(@ModelAttribute("event") Event event) {
		System.out.println(event);
		
		return "redirect:index.html";
		//return "event";
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
