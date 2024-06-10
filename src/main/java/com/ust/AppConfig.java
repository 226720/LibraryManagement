package com.ust;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class AppConfig {
	 @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
	 @Bean
		public OpenAPI customOpenAPI() {
			 
			return new OpenAPI().addServersItem(new Server().url("http://localhost:8080/"))
			.components(new Components().addSecuritySchemes("basicScheme", new SecurityScheme()
					.type(SecurityScheme.Type.HTTP).scheme("basic")))
			.info(new Info().title("Library Management").description("Library Managing Application"));
					
		}
		

}
