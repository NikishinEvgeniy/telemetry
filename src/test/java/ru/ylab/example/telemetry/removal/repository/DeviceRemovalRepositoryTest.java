package ru.ylab.example.telemetry.removal.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ru.ylab.example.telemetry.configuration.repository.RepositoryTest;
import ru.ylab.example.telemetry.share.Device;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RepositoryTest
@DisplayName("Домен [Device].[removal] настройка репозитория|сущности")
@Sql(scripts = "/sql/removal/device-removal-repository-mock-device.sql")
class DeviceRemovalRepositoryTest {

    @Autowired
    private DeviceRemovalRepository deviceRemovalRepository;

    @Test
    @DisplayName("Домен [Device].[removal] проверка корректной настройки репозитория|сущности")
    void shouldDeleteDeviceWhenDeviceExists() {
        // Arrange
        long deviceId = 999L;

        // Act
        deviceRemovalRepository
                .findById(deviceId)
                .ifPresent(deviceRemovalRepository::delete);
        Optional<Device> afterRemovalDevice = deviceRemovalRepository.findById(deviceId);


        // Assert
        assertThat(afterRemovalDevice.isEmpty())
                .as("Migration has device with id %d, after removal ...findById(%d) must be empty".formatted(deviceId, deviceId))
                .isTrue();
    }
}