package ru.ylab.example.telemetry.removal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ylab.example.telemetry.removal.service.DeviceRemovalService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/devices")
public class DeviceRemovalControllerV1 {

    private final DeviceRemovalService deviceRemovalServiceImpl;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id){
        deviceRemovalServiceImpl.deleteDevice(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}