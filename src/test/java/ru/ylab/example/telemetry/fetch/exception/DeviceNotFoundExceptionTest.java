package ru.ylab.example.telemetry.fetch.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ylab.example.telemetry.fetch.mapper.DeviceFetchMapper;
import ru.ylab.example.telemetry.fetch.repository.DeviceFetchRepository;
import ru.ylab.example.telemetry.fetch.service.impl.DeviceFetchServiceImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Домен [Device].[fetch] тестирование ошибки DeviceNotFoundException")
class DeviceNotFoundExceptionTest {

    @Mock
    private DeviceFetchMapper deviceFetchMapper;

    @Mock
    private DeviceFetchRepository deviceFetchRepository;

    @InjectMocks
    private DeviceFetchServiceImpl deviceFetchServiceImpl;

    @Test
    @DisplayName("Домен [Device].[fetch] проверка корректного содержания сообщения в ошибке")
    void shouldContainsCorrectExceptionMessageWhenDeviceNotFoundExceptionThrows() {
        // Arrange
        Long deviceId = 1L;
        when(deviceFetchRepository.findById(deviceId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> deviceFetchServiceImpl.fetch(deviceId))
                .isInstanceOf(DeviceNotFoundException.class)
                .hasMessage("Устройство [с уникальным идентификатором 1] не найдено");
    }
}