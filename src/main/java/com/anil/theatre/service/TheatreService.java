package com.anil.theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.theatre.entity.TheatreEntity;
import com.anil.theatre.repository.TheatreRepository;

@Service
public class TheatreService {
	@Autowired
	TheatreRepository theatreRepository;

	public List<TheatreEntity> getTheatreList() {
		return theatreRepository.findAll();
	}

	public void addTheatre() {
		TheatreEntity t = new TheatreEntity(0,"City Pride", "Pune","Wakad");
		theatreRepository.save(t);
	}

}
