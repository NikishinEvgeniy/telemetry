package ru.ylab.example.telemetry.add.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ylab.example.telemetry.add.dto.DeviceAdditionDto;
import ru.ylab.example.telemetry.add.mapper.DeviceAdditionMapper;
import ru.ylab.example.telemetry.add.service.DeviceAdditionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/devices")
public class DeviceListController {

    private final DeviceAdditionService deviceAdditionServiceImpl;

    @PostMapping
    public ResponseEntity<Void> addDevice(@RequestBody DeviceAdditionDto dto) {
        deviceAdditionServiceImpl.addDevice(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}