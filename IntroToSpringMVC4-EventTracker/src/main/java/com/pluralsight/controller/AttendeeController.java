package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pluralsight.model.Attendee;
import com.pluralsight.model.Event;

@Controller
public class AttendeeController {
	
	@RequestMapping(value="/attendee", method=RequestMethod.GET)
	public String displayAttendeePage(Model model) {
		Attendee attendee = new Attendee();
		
		/*attendee.setName("Gosho");
		attendee.setEmailAddress("gosho@gmail.com");*/
		model.addAttribute("attendee", attendee);
		
		return "attendee";
	}
	
	@RequestMapping(value="/attendee", method=RequestMethod.POST)
	public String processAttendee(@ModelAttribute("attendee") Attendee attendee) {
		System.out.println(attendee);
		return "redirect:index.html";
	}
}
