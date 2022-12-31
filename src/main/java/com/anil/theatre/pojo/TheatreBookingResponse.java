package com.anil.theatre.pojo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TheatreBookingResponse {
	
	Map<String, Object> hmTheatreBookingResponse = new HashMap<String, Object>(1,2);
	HttpStatus httpStatus;
	
}
