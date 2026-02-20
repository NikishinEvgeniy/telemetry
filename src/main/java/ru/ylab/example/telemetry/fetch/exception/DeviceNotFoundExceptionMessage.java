package ru.ylab.example.telemetry.fetch.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeviceNotFoundExceptionMessage {
    public static final String DEVICE_NOT_FOUND_EXCEPTION_MESSAGE = "Устройство [с уникальным идентификатором %d] не найдено";
}