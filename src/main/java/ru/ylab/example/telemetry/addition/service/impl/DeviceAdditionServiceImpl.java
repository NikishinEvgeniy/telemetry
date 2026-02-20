package ru.ylab.example.telemetry.addition.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ylab.example.telemetry.addition.mapper.DeviceAdditionMapper;
import ru.ylab.example.telemetry.addition.model.DeviceAdditionDto;
import ru.ylab.example.telemetry.addition.repository.DeviceAdditionRepository;
import ru.ylab.example.telemetry.addition.service.DeviceAdditionService;
import ru.ylab.example.telemetry.share.Device;

@Service
@RequiredArgsConstructor
public class DeviceAdditionServiceImpl implements DeviceAdditionService {

    private final DeviceAdditionMapper deviceAdditionMapper;
    private final DeviceAdditionRepository deviceAdditionRepository;

    @Override
    public void addDevice(DeviceAdditionDto deviceAddition) {
        Device device = deviceAdditionMapper.map(deviceAddition);
        deviceAdditionRepository.save(device);
    }
}