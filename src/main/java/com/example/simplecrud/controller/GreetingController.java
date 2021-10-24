package com.example.simplecrud.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.simplecrud.model.Tutorial;
import com.example.simplecrud.service.TutorialService;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/rest")
	public String getTutorials() {
		TutorialService service = new TutorialService();
		service.printTutorial();
		return "index";
	}
	
	
	
	
	@GetMapping("/rest2")
	public String getTutorials2() {
		TutorialService service = new TutorialService();
		Tutorial tutorial = service.getTutorialsById();
    	System.out.println("Title : " + tutorial.getTitle());
    	System.out.println("Description : " + tutorial.getDescription());
		return "index";
	}
	
	
	
	
	@GetMapping("/rest3")
	public String getTutorials3(Model model) {
		TutorialService service = new TutorialService();
		List<Tutorial> tutorials = service.getAllTutorials();
		model.addAttribute("listTutorials", tutorials);
		return "list";
	}
}
