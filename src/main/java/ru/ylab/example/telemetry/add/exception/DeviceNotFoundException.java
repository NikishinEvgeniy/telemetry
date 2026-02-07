package ru.ylab.example.telemetry.add.exception;

public class DeviceNotFoundException extends RuntimeException {

    public DeviceNotFoundException(Long id) {
        super("Устройство не найдено"+id);
    }
    public DeviceNotFoundException(String message) {
        super(message);
    }
    public DeviceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
