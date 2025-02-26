package com.daikichi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
	
	@GetMapping("/daikichi")
	public String welcome() {
		return "Welcome!!";
	}
	
	@GetMapping("/daikichi/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@GetMapping("/daikichi/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}

}
