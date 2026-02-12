package ru.ylab.example.telemetry.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ylab.example.telemetry.share.Device;

public interface DeviceListRepository extends JpaRepository<Device, Long> {
}