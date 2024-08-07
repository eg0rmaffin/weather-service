package ru.hawkingbros.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApiConfig {

    @Value("${gismeteo.api.token}")
    private String apiToken;

    public String getApiToken() {
        return apiToken;
    }
}

