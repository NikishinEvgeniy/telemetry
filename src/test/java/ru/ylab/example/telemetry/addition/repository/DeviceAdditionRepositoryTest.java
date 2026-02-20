package ru.ylab.example.telemetry.addition.repository;

import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ylab.example.telemetry.share.Device;
import ru.ylab.example.telemetry.configuration.repository.RepositoryTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;

@RepositoryTest
@DisplayName("Домен [Device].[addition] настройка репозитория|сущности")
class DeviceAdditionRepositoryTest {

    @Autowired
    private DeviceAdditionRepository deviceAdditionRepositoryImpl;

    @Test
    @DisplayName("Домен [Device].[addition] проверка корректной настройки репозитория|сущности")
    void shouldSuccessfulSavedDeviceWhenIncomingDeviceAdditionRequest() {
        // Arrange
        Device device = Instancio
                .of(Device.class)
                .ignore(field(Device::getId))
                .create();

        // Act
        Device savedDevice = deviceAdditionRepositoryImpl.save(device);
        Optional<Device> fetchedDevice = deviceAdditionRepositoryImpl.findById(savedDevice.getId());

        // Assert
        assertThat(fetchedDevice).isPresent();
        assertThat(fetchedDevice.get().getId()).isNotNegative();
    }
}