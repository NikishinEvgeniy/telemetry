package ru.ylab.example.telemetry.add.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ylab.example.telemetry.add.dto.AdditionDeviceDto;
import ru.ylab.example.telemetry.add.model.Device;
import ru.ylab.example.telemetry.add.repository.DeviceAdditionRepository;
import ru.ylab.example.telemetry.add.service.mapper.DeviceMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceAdditionRepository deviceAdditionRepository;
    private final DeviceMapper deviceMapper;


    public Device addDevice(AdditionDeviceDto dto) {
        // MapStruct создаст Device из DTO
        Device device = deviceMapper.toEntity(dto);
        return deviceAdditionRepository.save(device);
    }

}
