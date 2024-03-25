package com.microservices.todoservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.todoservices.configuration.TodoConfiguration;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	
	@Autowired
	private TodoConfiguration configuration;
	
	@GetMapping(path="/todo-services/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/todo-services/hello-world-bean/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
				
		return new HelloWorldBean(String.format("We hope you would enjoy managing your Todo's with us, %s.\n "
				+ "Your authentication mode currently is %s.",name, configuration.getAuthcontroller()));
	}

}
