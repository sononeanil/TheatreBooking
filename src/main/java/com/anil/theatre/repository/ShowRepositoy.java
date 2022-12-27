package com.anil.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anil.theatre.entity.ShowEntity;

@Repository
public interface ShowRepositoy extends JpaRepository<ShowEntity, Long>{

}
