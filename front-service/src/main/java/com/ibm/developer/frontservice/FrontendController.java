package com.ibm.developer.frontservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FrontendController {

	private RestTemplate restTemplate = new RestTemplate();

	private String welcomeMessage;

	public FrontendController(@Value("${WELCOME_MESSAGE}") String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}
	
	
	@GetMapping
	public String returnHelloMessage() throws InterruptedException {
		String podName = restTemplate.getForObject("http://backend-service:8080", String.class);
		return welcomeMessage + " " + podName;
	}
}
