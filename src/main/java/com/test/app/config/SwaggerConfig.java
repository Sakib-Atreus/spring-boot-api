package com.test.app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot - API",
                version = "1.1",
                description = "Spring Boot Product CRUD API with Order Management"
        )
)
public class SwaggerConfig {
}