package com.anil.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anil.theatre.entity.ScreenEntity;

@Repository
public interface ScreenRepository extends JpaRepository<ScreenEntity, Long> {
	

}
