package ru.ylab.example.telemetry.configuration.repository;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

import static ru.ylab.example.telemetry.configuration.repository.ContainerConfiguration.POSTGRESQL_IMAGE;

@TestConfiguration
public class PostgreSQLConfiguration {
    @Bean
    @ServiceConnection
    public PostgreSQLContainer<?> postgreSQLContainer() {
        return new PostgreSQLContainer<>(POSTGRESQL_IMAGE);
    }
}