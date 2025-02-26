package com.dojoTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Test {
	
	@RequestMapping("/")
	public String index() {
		return "NewFile.jsp";
	}

}
