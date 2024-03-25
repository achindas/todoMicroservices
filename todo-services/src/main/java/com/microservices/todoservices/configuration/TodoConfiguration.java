package com.microservices.todoservices.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("todo-service")
@RefreshScope	// Beans in RefreshScope picks up latest properties on receiving Refresh Event
				// OnRefreshEvent is triggered by triggering a blank POST event to http://localhost:<Port for this Microservice>/actuator/refresh
				// Remember to submit the POST request using JWT Token from Talend API Tester
public class TodoConfiguration {

	private String authcontroller;

	public String getAuthcontroller() {
		return authcontroller;
	}

	public void setAuthcontroller(String authcontroller) {
		this.authcontroller = authcontroller;
	}

}
