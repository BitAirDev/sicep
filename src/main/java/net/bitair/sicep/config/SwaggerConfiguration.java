/*
 * *******************************************************************************
 *   Copyright 2018 Modutram.
 * *******************************************************************************
 */

package net.bitair.sicep.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@Profile("!test")
public class SwaggerConfiguration {

	@Value("${swagger.apiInfo.title}")
	protected String swaggerTitle;

	@Value("${swagger.apiInfo.description}")
	protected String swaggerDescription;

	@Value("${swagger.apiInfo.termsOfServiceUrl}")
	protected String swaggerTermsOfServiceUrl;

	@Value("${swagger.apiInfo.contact}")
	protected String swaggerContact;

	@Value("${swagger.apiInfo.license}")
	protected String swaggerLicense;

	@Value("${swagger.apiInfo.licenseUrl}")
	protected String swaggerLicenseUrl;

	@Value("${application.version}")
	protected String swaggerAppVersion;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.modutram.ctz.controller")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo(swaggerTitle, swaggerDescription, swaggerAppVersion, swaggerTermsOfServiceUrl,
				swaggerContact, swaggerLicense, swaggerLicenseUrl);
		return apiInfo;
	}
}
