package com.anil.theatre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.theatre.pojo.TheatreBookingResponse;
import com.anil.theatre.service.ShowService;

@RestController
@RequestMapping("/api/v1/show")
public class ShowController {
	
	@Autowired
	ShowService showService;
	
	@GetMapping("/new")
	public void newShow() {
		showService.addNewShow();
	}
	
	@GetMapping("/browsetheatre/byshowname")
	public ResponseEntity<TheatreBookingResponse> getTheatreByShowName() {
		TheatreBookingResponse theatreBookingResponse = new TheatreBookingResponse();
		theatreBookingResponse.getTheatreBookingResponse().put("listOfTheatres", showService.getTheatreByShowName("Avatar"));
		return new ResponseEntity<TheatreBookingResponse>(theatreBookingResponse, HttpStatus.OK);
	}
	
	@GetMapping("/browsetheatre/bycity")
	public void getTheatreByCity() {
		
	}
	
	@GetMapping("/browsetheatre/bylanguage")
	public void getTheatreBylanguage() {
		
	}
	
	@GetMapping("/browsetheatre/bytype")
	public void getTheatreByType() {
		
	}

}
