package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Citizen;
import com.example.demo.repository.CitizenRepository;

@Service
public class CitizenService implements CitizenServiceInterface
{

	@Autowired
	private CitizenRepository repo;
	
	public List<Citizen> findbyVaccinationId(int id)
	{
		return repo.findByVaccinationCenterId(id);
	}
	
	public void addCitizen(Citizen citizen)
	{
		repo.save(citizen);
	}
}
