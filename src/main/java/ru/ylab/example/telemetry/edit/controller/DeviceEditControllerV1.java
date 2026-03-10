package ru.ylab.example.telemetry.edit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ylab.example.telemetry.edit.mapper.DeviceEditMapper;
import ru.ylab.example.telemetry.edit.model.DeviceEditDto;
import ru.ylab.example.telemetry.edit.model.DeviceEditRequest;
import ru.ylab.example.telemetry.edit.service.DeviceEditService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/devices")
public class DeviceEditControllerV1 {

    private final DeviceEditMapper deviceEditMapper;
    private final DeviceEditService deviceEditServiceImpl;

    @PutMapping("/{id}")
    public ResponseEntity<Void> editDevice(@PathVariable Long id, @RequestBody DeviceEditRequest deviceEditRequest) {
        DeviceEditDto deviceEdit = deviceEditMapper.map(id, deviceEditRequest);
        deviceEditServiceImpl.editDevice(deviceEdit);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}