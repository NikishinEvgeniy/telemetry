package ru.ylab.example.telemetry.fetch.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ru.ylab.example.telemetry.configuration.repository.RepositoryTest;
import ru.ylab.example.telemetry.share.Device;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RepositoryTest
@Sql(scripts = "/sql/fetch/device-fetch-repository-mock-device.sql")
@DisplayName("Домен [Device].[fetch] настройка репозитория|сущности")
class DeviceFetchRepositoryTest {

    @Autowired
    private DeviceFetchRepository deviceFetchRepository;

    @Test
    @DisplayName("Домен [Device].[fetch] проверка корректной настройки репозитория|сущности")
    void shouldReturnDeviceWhenDeviceExistInTheRepository() {
        // Arrange (migration)
        Long id = 104L;

        // Act
        Optional<Device> device = deviceFetchRepository.findById(id);

        // Assert
        assertThat(device)
                .as("Repository has mock device (see device-fetch-repository-mock-device.sql)")
                .isPresent();
    }
}