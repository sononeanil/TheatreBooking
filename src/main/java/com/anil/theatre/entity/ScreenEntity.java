package com.anil.theatre.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "SCREEN", uniqueConstraints = {@UniqueConstraint(columnNames = {"theatreId","screenId","startDate","endDate"})})
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
	@NotNull(message = "Theatre id can not be blank or NULL")
	private long theatreId;
	@NotNull(message = "Screen id can not be blank or NULL")
	private String screenId;
	@NotBlank(message = "Movie Name can not be blank or NULL")
	private String movieName;
	@NotNull(message = "Start Date can not be blank or NULL")
	private LocalDateTime startDate;
	@NotNull(message = "End date can not be blank or NULL")
	private LocalDateTime endDate;
	@NotNull(message = "Ticket Amount can not be blank or NULL")
	private float ticketAmount;
	

}
