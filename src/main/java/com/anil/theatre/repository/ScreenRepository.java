package com.anil.theatre.repository;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anil.theatre.entity.ScreenEntity;

@Repository
public interface ScreenRepository extends JpaRepository<ScreenEntity, Long> {


	ScreenEntity findByTheatreIdAndScreenIdAndStartDateAndEndDate(
			@NotNull(message = "Theatre id can not be blank or NULL") long theatreId,
			@NotNull(message = "Screen id can not be blank or NULL") String screenId,
			@NotNull(message = "Start Date can not be blank or NULL") LocalDateTime startDate,
			@NotNull(message = "End date can not be blank or NULL") LocalDateTime endDate);
	

}
