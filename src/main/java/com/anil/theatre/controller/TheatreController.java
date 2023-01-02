package com.anil.theatre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.theatre.entity.TheatreEntity;
import com.anil.theatre.pojo.TheatreBookingResponse;
import com.anil.theatre.service.TheatreService;

@RestController
@RequestMapping("/api/v1/theatre")
public class TheatreController {
	
	@Autowired
	TheatreService theatreService;
	
	@GetMapping("/first")
	public String getTheatreFirst() {
		theatreService.getTheatreList();
		return "Jay Shree Ganeshay Namah:";
	}
	
	@GetMapping("/list")
	public ResponseEntity<TheatreBookingResponse> getTheatreList() {
		 return new ResponseEntity<TheatreBookingResponse>(theatreService.getTheatreList(), HttpStatus.OK) ;
	}
	
	@GetMapping("/new")
	public ResponseEntity<TheatreBookingResponse> addTheatre(@RequestBody @Valid TheatreEntity theatreEntity) {
		return new ResponseEntity<>(theatreService.addTheatre(theatreEntity), HttpStatus.CREATED);
	}

}
