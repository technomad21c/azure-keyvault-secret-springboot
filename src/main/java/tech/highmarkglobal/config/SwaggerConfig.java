package tech.highmarkglobal.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	   @Bean
	   public Docket customImplementation(){
	      return new Docket(DocumentationType.SWAGGER_2)
	    	  .apiInfo(getApiInfo())	  
	    	  .select()
	          .apis(RequestHandlerSelectors.any())
	          .paths(PathSelectors.any())
	          .build();
	   }
	   @SuppressWarnings("rawtypes")
	private ApiInfo getApiInfo() {
		   return new ApiInfo("Highmark Global REST API for Bounty Microservices",

	                "Highmark Global REST API for Online Store",

	                "1.0",

	                "Terms of service",

	                new Contact("Highmark Global team", "", "admin@"),

	               "Apache License Version 2.0",

	                "https://www.apache.org/licenses/LICENSE-2.0", 
	              new ArrayList<VendorExtension>());
	   }
}