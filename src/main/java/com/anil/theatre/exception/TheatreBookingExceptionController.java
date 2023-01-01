package com.anil.theatre.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.anil.theatre.pojo.TheatreBookingResponse;
import com.anil.theatre.util.TheatreBookingConstants;

@RestControllerAdvice
public class TheatreBookingExceptionController {
	
	@ExceptionHandler(value = InvalidTheatreIdException.class)
	public ResponseEntity<TheatreBookingResponse> exception(InvalidTheatreIdException invalidTheatreIdException){
		TheatreBookingResponse theatreBookingResponse = new TheatreBookingResponse();
		theatreBookingResponse.getTheatreBookingResponse().put(TheatreBookingConstants.EXCEPTION_MESSAGE, invalidTheatreIdException.userMessage);
		theatreBookingResponse.getTheatreBookingResponse().put("exception", invalidTheatreIdException.toString());
		theatreBookingResponse.setHttpStatus(invalidTheatreIdException.getHttpStatus());
		return new ResponseEntity<>(theatreBookingResponse, invalidTheatreIdException.getHttpStatus());
	}
	
	@ExceptionHandler(value = TheatreBookingInvalidInputException.class)
	public ResponseEntity<TheatreBookingResponse> handleTheatreBookingInvalidInputException(TheatreBookingInvalidInputException theatreBookingInvalidInputException){
		TheatreBookingResponse theatreBookingResponse = new TheatreBookingResponse();
		theatreBookingResponse.getTheatreBookingResponse().put(TheatreBookingConstants.EXCEPTION_MESSAGE, theatreBookingInvalidInputException.getUserMessage());
		theatreBookingResponse.getTheatreBookingResponse().put("exception", theatreBookingInvalidInputException.toString());
		return new ResponseEntity<>(theatreBookingResponse, theatreBookingInvalidInputException.getHttpStatus());
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<TheatreBookingResponse> handleConstraintexception(ConstraintViolationException constraintViolationException) {
		TheatreBookingResponse theatreBookingResponse = new TheatreBookingResponse();
		theatreBookingResponse.getTheatreBookingResponse().put(TheatreBookingConstants.EXCEPTION_MESSAGE, "Constraint Violation Exception for below items");
		theatreBookingResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
		List<String> constrainViolaitonList = constraintViolationException.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
		constrainViolaitonList.forEach(e -> {
			theatreBookingResponse.getTheatreBookingResponse().put(e.toString(), e.toString());
		});
		return new ResponseEntity<>(theatreBookingResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<TheatreBookingResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
		Map<String, String> hmValidationMessage = new HashMap<>();
		
		TheatreBookingResponse theatreBookingResponse = new TheatreBookingResponse();
		
		methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(validationMessage ->{
			hmValidationMessage.put(validationMessage.getField(), validationMessage.getDefaultMessage());
		});
		theatreBookingResponse.getTheatreBookingResponse().put("Validation Failed", hmValidationMessage);
		theatreBookingResponse.getTheatreBookingResponse().put("Exception",methodArgumentNotValidException.getLocalizedMessage());
		return new ResponseEntity<>(theatreBookingResponse, HttpStatus.BAD_REQUEST);
	}

}
