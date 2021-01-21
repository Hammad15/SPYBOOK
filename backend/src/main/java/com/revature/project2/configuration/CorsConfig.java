package com.revature.project2.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
//		registry.addMapping("/**") // all endpoints in the api
//
//				.allowedOrigins("http://localhost:1234", "http://localhost:3000",
//						"http://ec2-18-223-151-37.us-east-2.compute.amazonaws.com/",
//						"http://java-react-team5-project2.s3-website.us-east-2.amazonaws.com/") // YOU MIGHT HAVE TO ADD
//																								// OR CHANGE
//				.allowedMethods("PUT", "DELETE", "GET", "OPTIONS", "POST", "PATCH")
//				.allowedHeaders("header1", "Content-Type", "Authorization")// YOU MIGHT HAVE TO ADD HEADERS
////        .exposedHeaders("header1", "header2")
//				.allowCredentials(true);
	}
}
