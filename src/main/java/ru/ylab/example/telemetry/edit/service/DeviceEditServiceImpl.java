package ru.ylab.example.telemetry.edit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ylab.example.telemetry.edit.mapper.DeviceEditMapper;
import ru.ylab.example.telemetry.edit.model.DeviceEditDto;
import ru.ylab.example.telemetry.edit.repository.DeviceEditRepository;
import ru.ylab.example.telemetry.share.Device;

@Service
@RequiredArgsConstructor
public class DeviceEditServiceImpl implements DeviceEditService {

    private final DeviceEditMapper deviceEditMapper;
    private final DeviceEditRepository deviceEditRepository;

    @Override
    public void editDevice(DeviceEditDto deviceEdit) {
        Device device = deviceEditMapper.map(deviceEdit);
        deviceEditRepository.save(device);
    }
}