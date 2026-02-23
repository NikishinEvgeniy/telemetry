package ru.ylab.example.telemetry.fetch.exception.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ylab.example.telemetry.fetch.exception.DeviceNotFoundException;
import ru.ylab.example.telemetry.fetch.exception.mapper.DeviceFetchExceptionMapper;
import ru.ylab.example.telemetry.fetch.exception.model.DeviceFetchExceptionResponse;

@RestControllerAdvice
@RequiredArgsConstructor
public class DeviceFetchControllerAdvice {

    private final DeviceFetchExceptionMapper deviceFetchExceptionMapperImpl;

    @ExceptionHandler(DeviceNotFoundException.class)
    public ResponseEntity<DeviceFetchExceptionResponse> handleDeviceNotFoundException(DeviceNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(deviceFetchExceptionMapperImpl.map(exception.getMessage()));
    }
}