package com.admin.tool.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.admin.tool.resource"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
			"Admin Service API",
			"This Admin Service API is being used to trigger Start and Stop the Server",
			"Admin Service API",
			"This is Admin Service API",
			new Contact("Abhilash", "www.adminservice.com", "customersupport@accentrue.com"),
			"License of API", "Abhilash", Collections.emptyList());
			
	}

}
