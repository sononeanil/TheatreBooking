package com.anil.theatre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anil.theatre.entity.TheatreEntity;
import com.anil.theatre.pojo.SearchResult;

@Repository
public interface TheatreRepository extends JpaRepository<TheatreEntity, Long>{


	TheatreEntity findByNameIgnoreCaseContainingAndAddressIgnoreCaseContainingAndCityIgnoreCaseContaining(String name,
			String address, String city);
	
	@Query("SELECT new com.anil.theatre.pojo.SearchResult( t.name, s.movieName) FROM TheatreEntity t JOIN t.lstScreenEntity s")
	public List<SearchResult> broseTheatreByMoveName();

}
