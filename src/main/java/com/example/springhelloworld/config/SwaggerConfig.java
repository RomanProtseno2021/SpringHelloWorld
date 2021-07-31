package com.example.springhelloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        List<ResponseMessage> statusResponses = Arrays.asList(
                new ResponseMessageBuilder().code(240).message("User error").build(),
                new ResponseMessageBuilder().code(401).message("Unauthorized").build(),
                new ResponseMessageBuilder().code(403).message("Forbidden").build(),
                new ResponseMessageBuilder().code(404).message("Not Found").build(),

                new ResponseMessageBuilder().code(500).message("Internal server error")
                        .build()
        );
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springhelloworld.controllers"))
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, statusResponses)
                .globalResponseMessage(RequestMethod.POST, statusResponses)
                .globalResponseMessage(RequestMethod.PATCH, statusResponses)
                .globalResponseMessage(RequestMethod.PUT, statusResponses)
                .globalResponseMessage(RequestMethod.DELETE, statusResponses);
    }


    private ApiInfo apiInfo() {
        return new ApiInfo(
                "test", "test", "1.0",
                null /*
         * terms of service
         */,
                null,
                null /*
         * license
         */,
                null /*
         * license url
         */,
                Collections.emptyList());
    }

    /**
     * конфигурация swagger-ui
     *
     * @return конфигурация swagger-ui
     */
    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(Boolean.TRUE)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }

}
