package com.anil.theatre.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheatreBookingInvalidInputException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8299896081448291878L;
	Exception exception;
	String userMessage;
	HttpStatus httpStatus;
	

}
