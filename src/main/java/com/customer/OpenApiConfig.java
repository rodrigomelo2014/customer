package com.customer;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/** Swagger API settings. */
@Configuration
public class OpenApiConfig {

    @Autowired
    private Environment env;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(
                        new Info()
                                .title(env.getProperty("info.app.name"))
                                .description(env.getProperty("info.app.description"))
                                .version(env.getProperty("info.app.version")));
    }
}