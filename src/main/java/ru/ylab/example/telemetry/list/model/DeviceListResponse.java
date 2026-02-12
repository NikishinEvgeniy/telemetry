package ru.ylab.example.telemetry.list.model;

import java.util.List;

public record DeviceListResponse(
        List<DeviceResponse> devices
) {
}