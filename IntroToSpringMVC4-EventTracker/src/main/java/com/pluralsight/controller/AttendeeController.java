package com.pluralsight.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pluralsight.model.Attendee;

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
	public String processAttendee(@Valid Attendee attendee, BindingResult result, Model m) {
	//public String processAttendee(@ModelAttribute("attendee") Attendee attendee) {
		System.out.println(attendee);
		
		if (result.hasErrors()) {
			return "attendee";
		}
		
		return "redirect:index.html";
	}
}
