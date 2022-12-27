package com.anil.theatre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.theatre.entity.TheatreEntity;
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
	public List<TheatreEntity> getTheatreList() {
		return theatreService.getTheatreList();
	}
	
	@GetMapping("/theatre")
	public void addTheatre() {
		theatreService.addTheatre();
	}

}
