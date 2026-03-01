package ru.ylab.example.telemetry.removal.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.ylab.example.telemetry.configuration.IntegrationTest;
import ru.ylab.example.telemetry.removal.repository.DeviceRemovalRepository;
import ru.ylab.example.telemetry.removal.service.DeviceRemovalService;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
@Sql("/sql/removal/device-removal-repository-mock-device.sql")
@DisplayName("Домен [Device].[removal] тестирование полного функционала")
class DeviceRemovalControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private DeviceRemovalService deviceRemovalServiceImpl;

    @MockitoSpyBean
    private DeviceRemovalRepository deviceRemovalRepository;

    @Test
    @SneakyThrows
    @DisplayName("Домен [Device].[removal] проверка корректной работы всего функционала")
    void shouldRemoveDeviceWhenIncomingRequestIsDeleteRequest() {
        // Arrange
        Long deviceId = 999L;
        RequestBuilder deleteRequest = MockMvcRequestBuilders.delete("/api/v1/devices/{id}", deviceId);


        // Act
        mockMvc.perform(deleteRequest)
                .andExpect(status().isNoContent());

        // Assert
        verify(deviceRemovalServiceImpl).deleteDevice(deviceId);
        verify(deviceRemovalRepository).deleteById(deviceId);
    }
}