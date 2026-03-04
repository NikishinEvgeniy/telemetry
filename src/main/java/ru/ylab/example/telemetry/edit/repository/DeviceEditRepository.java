package ru.ylab.example.telemetry.edit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ylab.example.telemetry.share.Device;

public interface DeviceEditRepository extends JpaRepository<Device, Long> {
}
