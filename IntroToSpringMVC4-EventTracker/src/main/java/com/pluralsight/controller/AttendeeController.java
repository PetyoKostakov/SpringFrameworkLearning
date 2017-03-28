package com.pluralsight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.pluralsight.model.Attendee;
import com.pluralsight.service.AttendeeService;

@Controller
public class AttendeeController {
	
	@Autowired
	private AttendeeService attendeeService;
	
	@RequestMapping(value="/attendee", method=RequestMethod.GET)
	public String displayAttendeePage(Model model) {
		Attendee attendee = new Attendee();
		
		/*attendee.setName("Gosho");
		attendee.setEmailAddress("gosho@gmail.com");*/
		model.addAttribute("attendee", attendee);
		
		return "attendee";
	}
	
	@RequestMapping(value="/attendeeList", method=RequestMethod.GET)
	public String displayAttendeeLostPage(Model model) {
		List<Attendee> attendees = attendeeService.getAll();
		
		model.addAttribute("attendees", attendees);
		
		return "attendeeList";
	}
	
	@RequestMapping(value="/attendee", method=RequestMethod.POST)
	public String processAttendee(@Valid Attendee attendee, BindingResult result, Model m) {
	//public String processAttendee(@ModelAttribute("attendee") Attendee attendee) {
		System.out.println(attendee);
		
		if (result.hasErrors()) {
			return "attendee";
		} else {
			attendeeService.save(attendee);
		}
		
		return "redirect:index.html";
	}
	
	/* REST SERVICES*/
	
	@RequestMapping(value = "/api/attendee", method = RequestMethod.GET)
    public ResponseEntity<List<Attendee>> listAllAttendees() {
        List<Attendee> attendees = attendeeService.getAll();
        if(attendees.isEmpty()){
            return new ResponseEntity<List<Attendee>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Attendee>>(attendees, HttpStatus.OK);
    }
	/* 
	@RequestMapping(value = "/api/attendee/", method = RequestMethod.POST)
	public ResponseEntity<Void> createAttendee(@RequestBody Attendee attendee, UriComponentsBuilder ucBuilder) {
		System.out.println("/api/attendee/ - POST");

		if (userService.isUserExist(user)) {
			System.out.println("A User with name " + user.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		attendeeService.save(attendee);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/attendee/{id}").buildAndExpand(attendee.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	*/
	
	@RequestMapping(value = "/api/attendee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Attendee> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Attendee attendee = attendeeService.getAttendee(id);
        if (attendee == null) {
            System.out.println("Attendee with id " + id + " not found");
            return new ResponseEntity<Attendee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Attendee>(attendee, HttpStatus.OK);
    }
}
