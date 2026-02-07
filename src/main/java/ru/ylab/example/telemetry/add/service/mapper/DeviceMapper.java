package ru.ylab.example.telemetry.add.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.ylab.example.telemetry.add.dto.AdditionDeviceDto;
import ru.ylab.example.telemetry.add.model.Device;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    @Mapping(target = "id", ignore = true)
    Device toEntity(AdditionDeviceDto dto);

    AdditionDeviceDto toDto(Device device);
}
