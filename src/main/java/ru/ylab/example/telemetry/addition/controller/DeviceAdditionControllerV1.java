package ru.ylab.example.telemetry.addition.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ylab.example.telemetry.addition.model.DeviceAdditionDto;
import ru.ylab.example.telemetry.addition.model.DeviceAdditionRequest;
import ru.ylab.example.telemetry.addition.mapper.DeviceAdditionMapper;
import ru.ylab.example.telemetry.addition.service.DeviceAdditionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/devices")
public class DeviceAdditionControllerV1 {

    private final DeviceAdditionMapper deviceAdditionMapper;
    private final DeviceAdditionService deviceAdditionServiceImpl;

    @PostMapping
    public ResponseEntity<Void> addDevice(@RequestBody DeviceAdditionRequest  deviceAdditionRequest ) {
        DeviceAdditionDto deviceAddition = deviceAdditionMapper.map(deviceAdditionRequest);
        deviceAdditionServiceImpl.addDevice(deviceAddition);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}