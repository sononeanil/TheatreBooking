package com.anil.theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.theatre.entity.ShowEntity;
import com.anil.theatre.repository.ShowRepositoy;

@Service
public class ShowService {
	@Autowired
	ShowRepositoy showRepositoy;

	public void addNewShow() {
		ShowEntity showEntity = new ShowEntity(0,"1","Avatar","Pune","Eng", null, "Action", null, null,null);
		showRepositoy.save(showEntity);
	}

	public List<ShowEntity> getTheatreByShowName(String showName) {
		return showRepositoy.findAllByName(showName);
	}
	
	

}
