package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@Value("${ENV_VAR}")
	private String envVariable;

	@GetMapping(path = {"/", "/hello"})
	public String hello() {
		final String uri = "http://nginx-clusterip-service/";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		result = result + "This is from Spring Boot service";
		result = result + envVariable;
		return result;
	}

}
