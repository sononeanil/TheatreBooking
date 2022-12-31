package com.anil.theatre.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.anil.theatre.pojo.TheatreBookingResponse;
import com.anil.theatre.util.TheatreBookingConstants;

@RestControllerAdvice
public class TheatreBookingExceptionController {
	
	@ExceptionHandler(value = InvalidTheatreIdException.class)
	public ResponseEntity<TheatreBookingResponse> exception(InvalidTheatreIdException invalidTheatreIdException){
		TheatreBookingResponse theatreBookingResponse = new TheatreBookingResponse();
		theatreBookingResponse.getHmTheatreBookingResponse().put(TheatreBookingConstants.EXCEPTION_MESSAGE, invalidTheatreIdException.getUserMessage());
		theatreBookingResponse.setHttpStatus(invalidTheatreIdException.getHttpStatus());
		return new ResponseEntity<>(theatreBookingResponse, invalidTheatreIdException.getHttpStatus());
	}

}
