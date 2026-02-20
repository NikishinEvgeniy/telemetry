package ru.ylab.example.telemetry.addition.service;

import ru.ylab.example.telemetry.addition.model.DeviceAdditionDto;

public interface DeviceAdditionService {
    void addDevice(DeviceAdditionDto deviceAddition);
}