package com.anil.theatre.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.anil.theatre.entity.ScreenEntity;
import com.anil.theatre.entity.TheatreEntity;
import com.anil.theatre.exception.InvalidTheatreIdException;
import com.anil.theatre.exception.TheatreBookingInvalidInputException;
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
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.ENGLISH);
//		ScreenEntity screenEntity = new ScreenEntity(0,1,"", "Avatar", formatter.parse("29-Dec-2022 10:15 AM"), formatter.parse("29-Dec-2022 12:15 AM"),200);
		try {
			if(theatreRepository.findById(screenEntity.getTheatreId()).isPresent()) {
				 theatreBookingResponse.getTheatreBookingResponse().put("screenEnrolled", screenRepository.save(screenEntity));
			}
			else throw new InvalidTheatreIdException(new Exception("Theatre Does not exists in DB"), TheatreBookingConstants.INVALID_THEATREiD, HttpStatus.BAD_REQUEST);
		}catch(DataIntegrityViolationException e) {
			long key = screenRepository.findByTheatreIdAndScreenIdAndStartDateAndEndDate(
					screenEntity.getTheatreId(), screenEntity.getScreenId(), screenEntity.getStartDate(), screenEntity.getEndDate()).getId();
			throw new TheatreBookingInvalidInputException(e, "TheatreId, ScreenId, Start Date and End Date attribute must be unique. Screen with this details already exists with id " + key,HttpStatus.CONFLICT);
		}
		 return theatreBookingResponse;
	}
	
	

}
