package com.queue.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket userServiceApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("v1")
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.queue.demo.web.rest"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.version("1.0")
				.title("Spring Boot Rest API")
				.description("Documentation Queue Service API v1.0")
				.build();
	}

}
