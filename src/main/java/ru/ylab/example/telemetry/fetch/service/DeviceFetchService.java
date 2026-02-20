package ru.ylab.example.telemetry.fetch.service;

import ru.ylab.example.telemetry.fetch.model.DeviceFetchDto;

public interface DeviceFetchService {
    DeviceFetchDto fetch(Long id);
}