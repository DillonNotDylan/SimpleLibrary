package com.lirbraryapp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Swagger UI at: http://localhost:8080/swagger-ui/index.html#/
 */
@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "Simple Library Application",
		description = "Bankend REST APIs for Banking App",
		version = "v1.0",
		contact = @Contact(
			name = "Dillon Burns",
			email = "dburns9898@gmail.com",
			url = "https://github.com/DillonNotDylan/"
		),
		license = @License(
			name = "Dillon Burns",
			url = "https://github.com/DillonNotDylan/"
		)
	),
	externalDocs = @ExternalDocumentation(
		description = "Simple Library Application",
		url = "https://github.com/DillonNotDylan/"
	)
)
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(@NonNull CorsRegistry registry) {
				registry.addMapping("/api/**")
				.allowedOrigins("http://localhost:5173")
				.allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONS");
			}
		};
	}

}
