package com.anil.theatre.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.theatre.entity.ScreenEntity;
import com.anil.theatre.entity.TheatreEntity;
import com.anil.theatre.repository.ScreenRepository;

@Service
public class ScreenService {
	@Autowired
	ScreenRepository screenRepository;

	public void enrollNewScreen() throws ParseException {
		TheatreEntity theatreEntity = new TheatreEntity(0, "Inox", "Wakad", "Pune");
//		Date startDate = new Date("29-Dec-2022");
//		Date endDate = new Date("31-Dec-2022");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.ENGLISH);
		ScreenEntity screenEntity = new ScreenEntity(0, theatreEntity,"A", "Avatar", formatter.parse("29-Dec-2022 10:15 AM"), formatter.parse("29-Dec-2022 12:15 AM"),200);
		
		screenRepository.save(screenEntity);
		
	}
	
	

}
