package com.programmingtechie.inventoryservice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    public Docket getApis() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("inventory-apis")
                .apiInfo(getApisInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }

    private ApiInfo getApisInfo() {
        return new ApiInfoBuilder()
                .title("inventory-apis")
                .description("inventory apis by programmingtechie")
                .version("1")
                .build();
    }
}
