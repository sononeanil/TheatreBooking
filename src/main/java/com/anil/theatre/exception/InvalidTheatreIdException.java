package com.anil.theatre.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvalidTheatreIdException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	Exception systemException;
	String userMessage;
	HttpStatus httpStatus;

}
