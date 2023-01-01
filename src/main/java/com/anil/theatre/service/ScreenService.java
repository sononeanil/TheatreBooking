package com.anil.theatre.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.anil.theatre.entity.ScreenEntity;
import com.anil.theatre.exception.InvalidTheatreIdException;
import com.anil.theatre.pojo.TheatreBookingResponse;
import com.anil.theatre.repository.ScreenRepository;
import com.anil.theatre.repository.TheatreRepository;
import com.anil.theatre.util.TheatreBookingConstants;

@Service
public class ScreenService {
	@Autowired
	ScreenRepository screenRepository;
	
	@Autowired
	TheatreRepository theatreRepository;

	public TheatreBookingResponse enrollNewScreen(ScreenEntity screenEntity) throws ParseException {
		TheatreBookingResponse theatreBookingResponse = new TheatreBookingResponse();
//		TheatreEntity theatreEntity = new TheatreEntity(0, "Inox", "Wakad", "Pune");
//		Date startDate = new Date("29-Dec-2022");
//		Date endDate = new Date("31-Dec-2022");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.ENGLISH);
//		ScreenEntity screenEntity = new ScreenEntity(0,1,"", "Avatar", formatter.parse("29-Dec-2022 10:15 AM"), formatter.parse("29-Dec-2022 12:15 AM"),200);
		if(theatreRepository.findById(screenEntity.getTheatreId()).isPresent()) {
			 theatreBookingResponse.getTheatreBookingResponse().put("screenEnrolled", screenRepository.save(screenEntity));
			 return theatreBookingResponse;
		}
		else throw new InvalidTheatreIdException(null, TheatreBookingConstants.INVALID_THEATREiD, HttpStatus.BAD_REQUEST);
	}
	
	

}
