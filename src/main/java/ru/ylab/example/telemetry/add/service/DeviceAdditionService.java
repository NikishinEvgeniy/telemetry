package ru.ylab.example.telemetry.add.service;

import ru.ylab.example.telemetry.add.dto.DeviceAdditionDto;

public interface DeviceAdditionService {
    void addDevice(DeviceAdditionDto deviceAddition);
}