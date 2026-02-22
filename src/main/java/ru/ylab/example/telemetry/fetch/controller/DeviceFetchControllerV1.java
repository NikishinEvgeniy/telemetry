package ru.ylab.example.telemetry.fetch.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ylab.example.telemetry.fetch.mapper.DeviceFetchMapper;
import ru.ylab.example.telemetry.fetch.model.DeviceFetchDto;
import ru.ylab.example.telemetry.fetch.model.DeviceFetchResponse;
import ru.ylab.example.telemetry.fetch.service.DeviceFetchService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/devices")
public class DeviceFetchControllerV1 {

    private final DeviceFetchMapper deviceFetchMapperImpl;
    private final DeviceFetchService deviceFetchServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<DeviceFetchResponse> fetch(@PathVariable("id") Long id) {
        DeviceFetchDto deviceFetch = deviceFetchServiceImpl.fetch(id);
        return ResponseEntity.ok(deviceFetchMapperImpl.map(deviceFetch));
    }
}