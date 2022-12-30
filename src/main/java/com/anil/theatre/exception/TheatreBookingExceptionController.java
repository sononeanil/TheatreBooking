package com.anil.theatre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.anil.theatre.pojo.TheatreBookingResponse;
import com.anil.theatre.util.TheatreBookingConstants;

@RestControllerAdvice
public class TheatreBookingExceptionController {
	
	@ExceptionHandler(value = InvalidTheatreId.class)
	public ResponseEntity<TheatreBookingResponse> exception(InvalidTheatreId invalidTheatreId){
		TheatreBookingResponse theatreBookingResponse = new TheatreBookingResponse();
		theatreBookingResponse.getHmTheatreBookingResponse().put(TheatreBookingConstants.EXCEPTION_MESSAGE, "Please Enter Valid Theatre Id or Create new Theatre with this id");
		return new ResponseEntity<>(theatreBookingResponse, HttpStatus.BAD_REQUEST);
	}

}
