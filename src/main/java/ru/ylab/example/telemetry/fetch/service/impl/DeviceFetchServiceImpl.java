package ru.ylab.example.telemetry.fetch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ylab.example.telemetry.fetch.exception.DeviceNotFoundException;
import ru.ylab.example.telemetry.fetch.mapper.DeviceFetchMapper;
import ru.ylab.example.telemetry.fetch.model.DeviceFetchDto;
import ru.ylab.example.telemetry.fetch.repository.DeviceFetchRepository;
import ru.ylab.example.telemetry.fetch.service.DeviceFetchService;

@Service
@RequiredArgsConstructor
public class DeviceFetchServiceImpl implements DeviceFetchService {

    private final DeviceFetchMapper deviceFetchMapperImpl;
    private final DeviceFetchRepository deviceFetchRepository;

    @Override
    public DeviceFetchDto fetch(Long id) {
        return deviceFetchRepository
                .findById(id)
                .map(deviceFetchMapperImpl::map)
                .orElseThrow(() -> new DeviceNotFoundException(id));
    }
}