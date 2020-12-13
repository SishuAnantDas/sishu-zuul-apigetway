package com.rick.zuul.disease.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/disease")
public class DiseaseResource {
	
	@GetMapping("/details")
	public List<String> getPatient(){
		return Arrays.asList("Thanda","Cancer");
	}

}
