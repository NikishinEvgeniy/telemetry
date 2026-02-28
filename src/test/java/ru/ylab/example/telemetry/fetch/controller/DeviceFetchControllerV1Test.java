package ru.ylab.example.telemetry.fetch.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.ylab.example.telemetry.configuration.IntegrationTest;
import ru.ylab.example.telemetry.fetch.mapper.DeviceFetchMapper;
import ru.ylab.example.telemetry.fetch.model.DeviceFetchDto;
import ru.ylab.example.telemetry.fetch.repository.DeviceFetchRepository;
import ru.ylab.example.telemetry.fetch.service.DeviceFetchService;
import ru.ylab.example.telemetry.share.Device;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
@Sql(scripts = "/sql/fetch/device-fetch-repository-mock-device.sql")
@DisplayName("Домен [Device].[fetch] тестирование полного функционала")
class DeviceFetchControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private DeviceFetchMapper deviceFetchMapperImpl;

    @MockitoSpyBean
    private DeviceFetchService deviceFetchServiceImpl;

    @MockitoSpyBean
    private DeviceFetchRepository deviceFetchRepository;

    @Test
    @SneakyThrows
    @DisplayName("Домен [Device].[fetch] проверка корректной работы всего функционала")
    void shouldReturnDeviceResponseWhenIncomingDeviceByIdGetRequest() {
        // Arrange
        Long deviceId = 104L;
        String expectedDeviceName = "fetch-mock-device";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/devices/{id}", deviceId);

        // Act
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(expectedDeviceName))
                .andExpect(jsonPath("$.id").value(deviceId));

        // Assert
        verify(deviceFetchServiceImpl).fetch(deviceId);
        verify(deviceFetchRepository).findById(deviceId);
        verify(deviceFetchMapperImpl).map(any(Device.class));
        verify(deviceFetchMapperImpl).map(any(DeviceFetchDto.class));
    }
}