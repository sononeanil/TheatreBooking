package com.anil.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anil.theatre.entity.TheatreEntity;

@Repository
public interface TheatreRepository extends JpaRepository<TheatreEntity, Long>{


	TheatreEntity findByNameIgnoreCaseContainingAndAddressIgnoreCaseContainingAndCityIgnoreCaseContaining(String name,
			String address, String city);

}
