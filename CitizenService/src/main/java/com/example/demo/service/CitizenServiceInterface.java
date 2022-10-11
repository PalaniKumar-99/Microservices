package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Citizen;

public interface CitizenServiceInterface {
	public List<Citizen> findbyVaccinationId(int id);
	
	public void addCitizen(Citizen citizen);

}
