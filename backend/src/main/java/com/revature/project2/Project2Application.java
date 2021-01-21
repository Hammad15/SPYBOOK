package com.revature.project2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Project2Application {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:1234", "http://localhost:3000",
								"http://ec2-18-223-151-37.us-east-2.compute.amazonaws.com",
								"http://java-react-team5-project2.s3-website.us-east-2.amazonaws.com") // YOU MIGHT
																										// HAVE TO ADD
																										// OR CHANGE
						.allowedMethods("PUT", "DELETE", "GET", "OPTIONS", "POST", "PATCH")
						.allowedHeaders("header1", "Content-Type", "Authorization")// YOU MIGHT HAVE TO ADD HEADERS
//        .exposedHeaders("header1", "header2")
						.allowCredentials(true);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}

}
