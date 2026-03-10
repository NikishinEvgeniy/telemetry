package ru.ylab.example.telemetry.edit.controller;

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
import ru.ylab.example.telemetry.edit.mapper.DeviceEditMapper;
import ru.ylab.example.telemetry.edit.model.DeviceEditDto;
import ru.ylab.example.telemetry.edit.model.DeviceEditRequest;
import ru.ylab.example.telemetry.edit.repository.DeviceEditRepository;
import ru.ylab.example.telemetry.edit.service.DeviceEditService;
import ru.ylab.example.telemetry.share.Device;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
@Sql(scripts = "/sql/edit/device-edit-repository-mock-device.sql")
@DisplayName("Домен [Device].[edit] тестирование полного функционала")
class DeviceEditControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private DeviceEditMapper deviceEditMapper;

    @MockitoSpyBean
    private DeviceEditService deviceEditService;

    @MockitoSpyBean
    private DeviceEditRepository deviceEditRepository;

    @Test
    @SneakyThrows
    @DisplayName("Домен [Device].[edit] проверка корректной работы всего функционала")
    void shouldReturnStatusNoContentWhenIncomingDevicePutRequest() {
        // Arrange
        Long deviceId = 1L;
        String deviceEditJson = "{\"name\":\"changed-name\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/v1/devices/{id}", deviceId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(deviceEditJson);

        // Act
        mockMvc.perform(requestBuilder)
                .andExpect(status().isNoContent());

        // Assert
        verify(deviceEditMapper).map(any(Long.class), any(DeviceEditRequest.class));
        verify(deviceEditService).editDevice(any(DeviceEditDto.class));
        verify(deviceEditMapper).map(any(DeviceEditDto.class));
        verify(deviceEditRepository).save(any(Device.class));
    }
}