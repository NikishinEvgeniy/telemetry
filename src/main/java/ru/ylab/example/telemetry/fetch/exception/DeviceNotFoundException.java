package ru.ylab.example.telemetry.fetch.exception;

import static ru.ylab.example.telemetry.fetch.exception.DeviceNotFoundExceptionMessage.DEVICE_NOT_FOUND_EXCEPTION_MESSAGE;

public class DeviceNotFoundException extends RuntimeException {
    public DeviceNotFoundException(Long deviceId) {
        super(DEVICE_NOT_FOUND_EXCEPTION_MESSAGE.formatted(deviceId));
    }
}