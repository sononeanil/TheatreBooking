package com.anil.theatre.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "THEATRE")
public class TheatreEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long theatreId;
	private String name;
	private String address;
	private String city;
	
	/*
	 * @OneToMany(targetEntity = ScreenEntity.class, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "theatreScreen_foreighKey", referencedColumnName =
	 * "theatreId") List<ScreenEntity> lstScreenEntity = new ArrayList<>();
	 */
}
