package com.microservices.basicauth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthController {
		
	@GetMapping(path = "/basicauth/{name}")
	public BasicAuthBean basicAuthBean(@PathVariable String name) {
		return new BasicAuthBean(String.format("You are authenticated %s",name));
	}

}
