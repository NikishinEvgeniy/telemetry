package ru.ylab.example.telemetry.removal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ylab.example.telemetry.share.Device;

public interface DeviceRemovalRepository extends JpaRepository<Device, Long> {
}