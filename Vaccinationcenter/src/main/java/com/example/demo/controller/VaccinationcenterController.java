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
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Citizen;
import com.example.demo.Model.RequiredResponce;
import com.example.demo.Repository.VaccinationRepository;
import com.example.demo.entity.VaccinationCenter;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationcenterController {
	@Autowired
	private VaccinationRepository centerRepo;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	public ResponseEntity<String> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter) {
		centerRepo.save(vaccinationCenter);
		return new ResponseEntity<String>("Vaccinationcenter added successfully", HttpStatus.OK);
	}

	@GetMapping("/getalldetails/{id}")
	@HystrixCommand(fallbackMethod = "handleCitizenDownTime")
	public ResponseEntity<RequiredResponce> getAllDataById(@PathVariable Integer id) {
		RequiredResponce rr = new RequiredResponce();
		// getting the vaccinationcenter details
		VaccinationCenter center = centerRepo.findById(id).get();
		rr.setCenter(center);
		// getting the citizenservice details

		List<Citizen> listOfCitizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/find/" + id,
				List.class);

		rr.setCitizens(listOfCitizens);
		return new ResponseEntity<RequiredResponce>(rr, HttpStatus.OK);
	}
	public ResponseEntity<RequiredResponce> handleCitizenDownTime(@PathVariable Integer id)
	{
		RequiredResponce rr = new RequiredResponce();
		VaccinationCenter center = centerRepo.findById(id).get();
		rr.setCenter(center);
		return new ResponseEntity<RequiredResponce>(rr,HttpStatus.OK);
	}

}
