package com.rick.zuul.doctor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorResource {
	
	@GetMapping("/details")
	public List<String> getDoctorList(){
		
		return Arrays.asList("Dr Sishu Anant Das","Dr Rick");
		
	}

}
