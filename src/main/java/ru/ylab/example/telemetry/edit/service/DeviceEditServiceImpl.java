package ru.ylab.example.telemetry.edit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ylab.example.telemetry.edit.mapper.DeviceEditMapper;
import ru.ylab.example.telemetry.edit.model.DeviceEditDto;
import ru.ylab.example.telemetry.edit.model.DeviceEditRequest;
import ru.ylab.example.telemetry.edit.model.DeviceEditResponse;
import ru.ylab.example.telemetry.edit.repository.DeviceEditRepository;
import ru.ylab.example.telemetry.share.Device;

@Service
@RequiredArgsConstructor
public class DeviceEditServiceImpl implements DeviceEditService {

    private final DeviceEditMapper deviceEditMapper;
    private final DeviceEditRepository deviceEditRepository;

    @Override
    public DeviceEditResponse editDevice(Long id, DeviceEditRequest request) {

        DeviceEditDto deviceEditDto = deviceEditMapper.mapResponse(request);
        Device device = deviceEditMapper.mapResponse(deviceEditDto);
        Device save = deviceEditRepository.save(device);

        return deviceEditMapper.mapResponse(save);
    }
}
