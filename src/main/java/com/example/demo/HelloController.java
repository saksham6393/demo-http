package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@GetMapping
	public String hello() {
		final String uri = "http://nginx-clusterip-service/";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		result = result + "This is from Spring Boot service";
		return result;
	}

}
