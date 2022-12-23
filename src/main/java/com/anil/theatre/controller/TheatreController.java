package com.anil.theatre.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/theatre")
public class TheatreController {
	
	@GetMapping("/list")
	public String getTheatreList() {
		return "Jay Shree Ganeshay Namah:";
	}

}
