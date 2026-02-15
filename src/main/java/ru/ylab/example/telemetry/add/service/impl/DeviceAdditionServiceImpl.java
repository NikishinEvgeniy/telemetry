package ru.ylab.example.telemetry.add.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ylab.example.telemetry.add.dto.DeviceAdditionDto;
import ru.ylab.example.telemetry.add.mapper.DeviceAdditionMapper;
import ru.ylab.example.telemetry.add.repository.DeviceAdditionRepository;
import ru.ylab.example.telemetry.add.service.DeviceAdditionService;
import ru.ylab.example.telemetry.share.Device;

@Service
@RequiredArgsConstructor
public class DeviceAdditionServiceImpl implements DeviceAdditionService {

    private final DeviceAdditionRepository deviceAdditionRepository;
    private final DeviceAdditionMapper deviceAdditionMapper;

    @Override
    public void addDevice(DeviceAdditionDto request) {
        Device device = deviceAdditionMapper.map(request);
        deviceAdditionRepository.save(device);
    }
}