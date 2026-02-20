package ru.ylab.example.telemetry.fetch.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ylab.example.telemetry.share.Device;

public interface DeviceFetchRepository extends CrudRepository<Device, Long> {
}