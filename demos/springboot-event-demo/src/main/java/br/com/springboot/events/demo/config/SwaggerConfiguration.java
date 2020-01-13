package br.com.springboot.events.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public Docket apiV1() { // @formatter:off
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("v1")
                .select()
                    .apis(RequestHandlerSelectors.basePackage("br.com.springboot.events.demo.controller"))
                    .paths(PathSelectors.regex("/api/v1.*"))
                .build()
                .apiInfo(apiInfo());
    } 
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.version("1.0")
				.title("Spring Boot Event Demo")
				.description("Spring Boot Event Demonstration")
				.build();
	}
	

}
