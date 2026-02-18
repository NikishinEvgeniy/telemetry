package ru.ylab.example.telemetry.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class CorsConfiguration implements WebMvcConfigurer {

    private final CorsSettings corsSettings;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/api/v1/**")
                .allowedOrigins(corsSettings.getAllowedOrigins());
    }
}