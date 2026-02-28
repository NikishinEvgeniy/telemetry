package ru.ylab.example.telemetry.removal.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ylab.example.telemetry.removal.repository.DeviceRemovalRepository;
import ru.ylab.example.telemetry.removal.service.DeviceRemovalService;

@Service
@RequiredArgsConstructor
public class DeviceRemovalServiceImpl implements DeviceRemovalService {

    private final DeviceRemovalRepository deviceRemovalRepository;

    @Override
    public void deleteDevice(Long id) {
        deviceRemovalRepository.deleteById(id);
    }
}