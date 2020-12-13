package com.rick.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class DoctorPortalDriverGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorPortalDriverGetwayApplication.class, args);
	}

}
