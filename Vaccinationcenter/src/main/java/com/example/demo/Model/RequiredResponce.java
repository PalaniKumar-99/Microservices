package com.example.demo.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.entity.VaccinationCenter;


public class RequiredResponce {
	private VaccinationCenter center;
	private List<Citizen> citizens;
	
	public RequiredResponce() {}

	public RequiredResponce(VaccinationCenter center, List<Citizen> citizens) {
		super();
		this.center = center;
		this.citizens = citizens;
	}

	public VaccinationCenter getCenter() {
		return center;
	}

	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}

	public List<Citizen> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	};
	
	
}
