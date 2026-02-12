package ru.ylab.example.telemetry.list.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ylab.example.telemetry.list.mapper.DeviceListMapper;
import ru.ylab.example.telemetry.list.model.DeviceListDto;
import ru.ylab.example.telemetry.list.model.DeviceListResponse;
import ru.ylab.example.telemetry.list.service.DeviceListService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/devices")
public class DeviceListControllerV1 {

    private final DeviceListMapper deviceListMapper;
    private final DeviceListService deviceListServiceImpl;

    @GetMapping
    public ResponseEntity<DeviceListResponse> getAllDevices(){
        DeviceListDto deviceList = deviceListServiceImpl.getAllDevices();
        DeviceListResponse deviceListResponse = deviceListMapper.map(deviceList);
        return ResponseEntity.ok(deviceListResponse);
    }
}