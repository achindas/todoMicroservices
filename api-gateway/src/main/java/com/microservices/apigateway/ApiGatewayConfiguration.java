package com.microservices.apigateway;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//@CrossOrigin(origins="http://localhost:4200")
@Configuration
public class ApiGatewayConfiguration { //extends org.springframework.web.cors.CorsConfiguration

	/*
	@Bean
	public CorsFilter corsWebFilter() {
		
        CorsConfiguration configuration = new CorsConfiguration();
        
        configuration.setAllowedOrigins(Collections.singletonList("*")); //http://localhost:4200/authenticate
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        //configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        return new CorsFilter((CorsConfigurationSource) source);
    }*/
	
	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
		//System.out.println("Entered gatewayRoutes");
        return builder.routes()
                .route(r -> r.path("/todo-services/**")
                		.uri("lb://todo-services"))
                		//.uri("http://localhost:8000/"))
                .build();
    }
	
}
