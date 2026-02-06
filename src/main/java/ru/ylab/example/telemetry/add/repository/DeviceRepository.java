package ru.ylab.example.telemetry.add.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ylab.example.telemetry.add.model.Device;

/**
Репозиторий для работы с device, дает доступ к стандартным crud операциям через JpaRepository
 */
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
