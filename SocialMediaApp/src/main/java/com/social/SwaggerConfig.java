package com.social;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	private final Contact CONTACT_INFO=new Contact("Jatinder","http://wwww.bal.jatinder.com","bal.jatinder@gmail.com");
	private final ApiInfo API_INFO=new ApiInfo("My First API", "My First RestControler API", "1.1",
			"Terms of service", CONTACT_INFO, "License of API", "License of API");
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(API_INFO);
	}

}
