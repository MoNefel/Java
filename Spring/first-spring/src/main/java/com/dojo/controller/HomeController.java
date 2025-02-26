package com.dojo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home controller";
	}
	
	@RequestMapping("/post")
	public String create() {
		return "create something";
	}
	
	//Query Parameters
	@RequestMapping("/test") //in the browser we write "http://localhost:8080/test?q=testing"
	public String paramTest(@RequestParam(value="q", required = false) String query) {
		if(query == null) {
			return "You searching for nothing";
		}
		return "The param is : " + query; //the output "The param is : testing"
	}
	
	
	//PathVariables
	@RequestMapping("/m/{courseId}/{moduleId}")
	public String showLesson(@PathVariable("courseId") String courseId, @PathVariable("moduleId") String moduleId) {
		return "Course: " + courseId + " Module: " + moduleId;
	}
	

}
