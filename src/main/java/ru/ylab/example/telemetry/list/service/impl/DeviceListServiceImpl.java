package ru.ylab.example.telemetry.list.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ylab.example.telemetry.list.mapper.DeviceListMapper;
import ru.ylab.example.telemetry.list.model.DeviceListDto;
import ru.ylab.example.telemetry.list.repository.DeviceListRepository;
import ru.ylab.example.telemetry.list.service.DeviceListService;
import ru.ylab.example.telemetry.share.Device;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceListServiceImpl implements DeviceListService {

    private final DeviceListMapper deviceListMapperImpl;
    private final DeviceListRepository deviceListRepository;

    @Override
    public DeviceListDto getAllDevices() {
        List<Device> devices = deviceListRepository.findAll();
        return deviceListMapperImpl.map(devices);
    }
}