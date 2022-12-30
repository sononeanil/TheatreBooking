package com.anil.theatre.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.theatre.service.ScreenService;

@RestController
@RequestMapping("/api/v1/screen")
public class ScreenController {
	
	@Autowired
	ScreenService screenService;
	
	@GetMapping("/enroll")
	public void enrollScreen() {
		try {
			screenService.enrollNewScreen();
		} catch (ParseException e) {
			e.printStackTrace(); 
		}
	}

}
