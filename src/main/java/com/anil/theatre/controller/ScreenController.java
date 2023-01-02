package com.anil.theatre.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.theatre.entity.ScreenEntity;
import com.anil.theatre.exception.InvalidTheatreIdException;
import com.anil.theatre.pojo.TheatreBookingResponse;
import com.anil.theatre.service.ScreenService;

@RestController
@RequestMapping("/api/v1/screen")
public class ScreenController {
	
	@Autowired
	ScreenService screenService;
	
	@GetMapping("/enroll")
	public ResponseEntity<TheatreBookingResponse> enrollScreen(@RequestBody @Valid ScreenEntity screenEntity) throws InvalidTheatreIdException {
		try {
			System.out.println("6a6a6a6a6a6a6a6a6");
			return new ResponseEntity<>(screenService.enrollNewScreen(screenEntity), HttpStatus.CREATED);
		} catch (ParseException e) {
			System.out.println("555555555555555555555");
			e.printStackTrace(); 
		}catch (Exception e) {
			System.out.println("666666666666666666666 " + e.getLocalizedMessage());
			e.printStackTrace(); 
			throw e;
		}
		TheatreBookingResponse s = new TheatreBookingResponse();
		s.getTheatreBookingResponse().put("myException", "myEx");
		return new ResponseEntity<TheatreBookingResponse>(s,HttpStatus.BAD_REQUEST);
	}

}
