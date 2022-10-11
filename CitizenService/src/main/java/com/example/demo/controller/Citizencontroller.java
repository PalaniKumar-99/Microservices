package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Citizen;
import com.example.demo.service.CitizenService;

@RestController
@RequestMapping("/citizen")
public class Citizencontroller 
{
	@Autowired
	private CitizenService service;
	
	@GetMapping("/find/{id}")
	public ResponseEntity<List<Citizen>> findbyVaccinationId(@PathVariable int id)
	{
		List<Citizen> listcitizen = service.findbyVaccinationId(id);
		return new ResponseEntity<List<Citizen>>(listcitizen,HttpStatus.OK);
	}
	
	@PostMapping("/addcitizen")
	public ResponseEntity<String> addCitizen(@RequestBody Citizen citizen)
	{
		service.addCitizen(citizen);
		return new ResponseEntity<String>("citizen added successfully",HttpStatus.OK);
	}
}
