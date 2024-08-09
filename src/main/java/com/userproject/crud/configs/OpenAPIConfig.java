package com.userproject.crud.configs;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public GroupedOpenApi restAPI(){
        return GroupedOpenApi.builder()
                .group("Rest")
                .pathsToMatch("/api/**")
                .build();

    }

    @Bean
    public GroupedOpenApi viewAPI(){
        return GroupedOpenApi.builder()
                .group("MVC")
                .pathsToMatch("/api/v2/**")
                .build();

    }
}
