package ru.ylab.example.telemetry.list.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ru.ylab.example.telemetry.configuration.repository.RepositoryTest;
import ru.ylab.example.telemetry.share.Device;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RepositoryTest
@Sql(scripts = "/sql/list/device-list-repository-mock-devices.sql")
@DisplayName("Домен [Device].[list] настройка репозитория|сущности")
class DeviceListRepositoryTest {

    @Autowired
    private DeviceListRepository deviceListRepository;

    @Test
    @DisplayName("Домен [Device].[list] проверка корректной настройки репозитория|сущности")
    void shouldReturnDeviceListWhenDevicesExistInTheRepository() {
        // Arrange (migration)


        // Act
        List<Device> devices = deviceListRepository.findAll();

        // Assert
        assertThat(devices)
                .as("Repository has 5 mock devices (see device-list-repository-mock-devices.sql)")
                .hasSize(5);
    }
}