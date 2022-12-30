package com.anil.theatre.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Screen")
public class ScreenEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="theatreId", referencedColumnName = "theatreId") private
	 * TheatreEntity theatreEntity;
	 */
	@Column(nullable = false)
	private long theatreId;
	@Column(nullable = false)
	private String screenId;
	@Column(nullable = false)
	private String movieName;
	@Column(nullable = false)
	private Date startDate;
	@Column(nullable = false)
	private Date endDate;
	@Column(nullable = false)
	private float ticketAmount;
	

}
