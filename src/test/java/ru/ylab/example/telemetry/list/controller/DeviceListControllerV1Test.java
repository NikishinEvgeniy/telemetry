package ru.ylab.example.telemetry.list.controller;

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
import ru.ylab.example.telemetry.list.mapper.DeviceListMapper;
import ru.ylab.example.telemetry.list.model.DeviceListDto;
import ru.ylab.example.telemetry.list.repository.DeviceListRepository;
import ru.ylab.example.telemetry.list.service.DeviceListService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
@Sql(scripts = "/sql/list/device-list-repository-mock-devices.sql")
@DisplayName("Домен [Device].[list] тестирование полного функционала")
class DeviceListControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private DeviceListMapper deviceListMapperImpl;

    @MockitoSpyBean
    private DeviceListService deviceListServiceImpl;

    @MockitoSpyBean
    private DeviceListRepository deviceListRepository;

    @Test
    @SneakyThrows
    @DisplayName("Домен [Device].[list] проверка корректной работы всего функционала")
    void shouldReturnDeviceListResponseWhenIncomingDevicesGetRequest() {
        // Arrange
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/devices");

        // Act
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.devices.size()").value(5));

        // Assert
        verify(deviceListServiceImpl).getAllDevices();
        verify(deviceListRepository).findAll();
        verify(deviceListMapperImpl).map(anyList());
        verify(deviceListMapperImpl).map(any(DeviceListDto.class));
    }
}