package com.microservices.todoservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	
	@GetMapping(path="/todo-services/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/todo-services/hello-world-bean/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("We hope you would enjoy managing your Todo's with us, %s",name));
	}

}
