package com.anil.theatre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.theatre.entity.ShowEntity;
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
	public List<ShowEntity> getTheatreByShowName() {
		return showService.getTheatreByShowName();
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
