package ru.ylab.example.telemetry.addition.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.ylab.example.telemetry.addition.mapper.DeviceAdditionMapper;
import ru.ylab.example.telemetry.addition.model.DeviceAdditionDto;
import ru.ylab.example.telemetry.addition.model.DeviceAdditionRequest;
import ru.ylab.example.telemetry.addition.repository.DeviceAdditionRepository;
import ru.ylab.example.telemetry.addition.service.DeviceAdditionService;
import ru.ylab.example.telemetry.configuration.IntegrationTest;
import ru.ylab.example.telemetry.share.Device;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
@DisplayName("Домен [Device].[addition] тестирование полного функционала")
class DeviceAdditionControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private DeviceAdditionMapper deviceAdditionMapperImpl;

    @MockitoSpyBean
    private DeviceAdditionService deviceAdditionServiceImpl;

    @MockitoSpyBean
    private DeviceAdditionRepository deviceAdditionRepository;

    @Test
    @SneakyThrows
    @DisplayName("Домен [Device].[addition] проверка корректной работы всего функционала")
    void shouldReturnStatusCreatedWhenIncomingDevicePostRequest() {
        // Arrange
        String deviceAdditionJson = "{\"name\":\"mock-device\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/devices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(deviceAdditionJson);

        // Act
        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated());

        // Assert
        verify(deviceAdditionMapperImpl).map(any(DeviceAdditionRequest.class));
        verify(deviceAdditionServiceImpl).addDevice(any(DeviceAdditionDto.class));
        verify(deviceAdditionMapperImpl).map(any(DeviceAdditionDto.class));
        verify(deviceAdditionRepository).save(any(Device.class));
    }
}