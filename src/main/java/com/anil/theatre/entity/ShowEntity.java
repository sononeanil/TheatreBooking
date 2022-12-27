package com.anil.theatre.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name ="Show")
public class ShowEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String theatreId;
	private String name;
	private String city;
	private int screenNumber;
	private String language;
	private String timings;
	private String type; //Action, horror, comedy
	private String hero;
	private String heroin;
	private String startDate;
	private String endDate;
	private String updatedBy;
	private String updatedTime;
	private String createdDate;
	private String createdBy;


}
