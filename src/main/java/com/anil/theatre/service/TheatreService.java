package com.anil.theatre.service;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.anil.theatre.entity.TheatreEntity;
import com.anil.theatre.exception.InvalidTheatreIdException;
import com.anil.theatre.exception.TheatreBookingInvalidInputException;
import com.anil.theatre.pojo.TheatreBookingResponse;
import com.anil.theatre.repository.TheatreRepository;
import com.anil.theatre.util.TheatreBookingConstants;

@Service
public class TheatreService {
	@Autowired
	TheatreRepository theatreRepository;

	public TheatreBookingResponse getTheatreList() {
		 TheatreBookingResponse theatreBookingResponse = new TheatreBookingResponse();
		 theatreBookingResponse.getTheatreBookingResponse().put("List of Theatre", theatreRepository.findAll());
		 return theatreBookingResponse;
	}

	public TheatreBookingResponse addTheatre(TheatreEntity theatreEntity) {
		TheatreBookingResponse theatreBookingResponse = null;
		try {
			theatreBookingResponse = new TheatreBookingResponse();
			 theatreBookingResponse.getTheatreBookingResponse().put("Theatre " + TheatreBookingConstants.ADDED_SUCCESSFULLY, theatreRepository.save(theatreEntity));
			 return theatreBookingResponse;
		}catch(DataIntegrityViolationException e) {
			TheatreEntity theatreEntity2 = theatreRepository.findByNameIgnoreCaseContainingAndAddressIgnoreCaseContainingAndCityIgnoreCaseContaining(theatreEntity.getName(),theatreEntity.getAddress(), theatreEntity.getCity());
			throw new TheatreBookingInvalidInputException(e, "All attribute must be unique. Theatre with this details already exists with id " + theatreEntity2.getTheatreId(),HttpStatus.CONFLICT);
		}catch(ConstraintViolationException e) {
			System.out.println("Ex....33333333333.........................");
		}
		
		catch (Exception e) {
			System.out.println("Ex.............................");
			e.printStackTrace();
		}
		return theatreBookingResponse;
	}

	public TheatreBookingResponse browseTheatreByMovieName() {
		try {
			TheatreBookingResponse theatreBookingResponse = new TheatreBookingResponse();
			theatreBookingResponse.getTheatreBookingResponse().put("searchResult", theatreRepository.broseTheatreByMoveName());
			return theatreBookingResponse;
		}catch(Exception exception) {
			exception.printStackTrace();
			throw new InvalidTheatreIdException(exception,"Exception while getting result from DB for browseTheatreByMovieName", HttpStatus.BAD_REQUEST);
		}
	}

}
