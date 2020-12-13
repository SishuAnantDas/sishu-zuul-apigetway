package com.rick.zuul.patient.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientResource {

	@GetMapping("/details")
	public List<String> getPatient(){
		return Arrays.asList("Biswa ranjan Jena","Priya Swain");
	}
}
