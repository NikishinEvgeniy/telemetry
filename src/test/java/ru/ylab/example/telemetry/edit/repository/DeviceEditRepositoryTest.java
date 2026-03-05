package ru.ylab.example.telemetry.edit.repository;

import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.ylab.example.telemetry.configuration.repository.RepositoryTest;
import ru.ylab.example.telemetry.share.Device;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.assertAll;

@RepositoryTest
@Sql(scripts = "/sql/edit/device-edit-repository-mock-device.sql")
@DisplayName("Домен [Device].[edit] настройка репозитория|сущности")
class DeviceEditRepositoryTest {

    @Autowired
    private DeviceEditRepository deviceEditRepository;

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @DisplayName("Домен [Device].[edit] проверка корректной настройки репозитория|сущности")
    void shouldEditDeviceWhenDeviceExistInTheRepository() {
        // Arrange
        Long deviceId = 1L;
        String expectedName = "updated-device";
        Device device = Instancio.of(Device.class)
                .set(field(Device::getId), deviceId)
                .set(field(Device::getName), expectedName)
                .create();

        // Act
        Optional<Device> savedDevice = deviceEditRepository.findById(deviceId);
        deviceEditRepository.save(device);
        Optional<Device> updatedDevice = deviceEditRepository.findById(deviceId);

        // Assert
        assertAll(() -> {
            assertThat(updatedDevice.isPresent())
                    .as("Previous device[%d] after updating still exists".formatted(deviceId))
                    .isTrue();
            assertThat(updatedDevice.get().getName()).isEqualTo(expectedName);
            assertThat(savedDevice.get()).isNotEqualTo(updatedDevice.get());
        });
    }
}