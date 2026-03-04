package ru.ylab.example.telemetry.edit.service;

import ru.ylab.example.telemetry.edit.model.DeviceEditRequest;
import ru.ylab.example.telemetry.edit.model.DeviceEditResponse;

public interface DeviceEditService {
    DeviceEditResponse editDevice(Long id, DeviceEditRequest request);
}
