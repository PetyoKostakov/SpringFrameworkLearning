package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping(value="/greeting")
	public String sayHello (Model model) {
		System.out.println("greeting controller");
		model.addAttribute("greeting", "say hello");
		
		return "hello";
	}
	
	@RequestMapping(value="/")
	public String root (Model model) {
		System.out.println("/ controller");
		model.addAttribute("greeting", "say hello");
		
		return "hello";
	}
}
