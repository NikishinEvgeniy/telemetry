package ru.ylab.example.telemetry.fetch.exception.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.ylab.example.telemetry.configuration.IntegrationTest;
import ru.ylab.example.telemetry.fetch.repository.DeviceFetchRepository;
import ru.ylab.example.telemetry.fetch.service.DeviceFetchService;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
@DisplayName("Домен [Device].[fetch] тестирование функционала обработки ошибок")
class DeviceFetchControllerAdviceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private DeviceFetchService deviceFetchServiceImpl;

    @MockitoSpyBean
    private DeviceFetchRepository deviceFetchRepository;

    @Test
    @SneakyThrows
    @DisplayName("Домен [Device].[fetch] проверка корректной обработки ошибки DeviceFetchExceptionResponse")
    void shouldReturnDeviceFetchExceptionResponseWhenIncomingDeviceByIdNotFound() {
        // Arrange
        Long deviceId = 999L;
        String expectedExceptionMessage = "Устройство [с уникальным идентификатором %d] не найдено".formatted(deviceId);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/devices/{id}", deviceId);

        // Act
        mockMvc.perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(expectedExceptionMessage));

        // Assert
        verify(deviceFetchServiceImpl).fetch(deviceId);
        verify(deviceFetchRepository).findById(deviceId);
    }
}