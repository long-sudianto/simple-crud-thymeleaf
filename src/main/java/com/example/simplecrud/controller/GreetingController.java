package com.example.simplecrud.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";//greeting.html
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/")
	public String index(Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy : HH:mm:ss");
		Date now = new Date();
		String dateStr = dateFormat.format(now);
		model.addAttribute("time", dateStr);
		return "index";
	}
}
