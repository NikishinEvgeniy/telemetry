package ru.ylab.example.telemetry.configuration.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContainerConfiguration {
    public static final String POSTGRESQL_IMAGE = "postgres:15-alpine";
}