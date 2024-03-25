package com.microservices.todoconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class TodoConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoConfigServerApplication.class, args);
	}

}
