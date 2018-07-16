package com.grainger.openshift.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@PropertySource("classpath:swagger.properties")
public class SwaggerConfiguration {

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.select().paths(PathSelectors.any()).build().pathMapping("/");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("IsoCode microservices REST API")
				.description(
						"Operations that can be invoked in the Spring Boot IsoCode microservices")
				.contact(
						new Contact("Grainger",
								"https://dvlospap001.gcom.grainger.com:8443",
								"")).license("")
				.licenseUrl("http://www.grainger.com").version("1.0.0").build();
	}

}
