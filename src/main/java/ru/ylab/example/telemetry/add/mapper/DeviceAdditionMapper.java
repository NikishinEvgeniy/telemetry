package ru.ylab.example.telemetry.add.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ylab.example.telemetry.add.dto.DeviceAdditionDto;
import ru.ylab.example.telemetry.share.Device;

@Mapper( unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeviceAdditionMapper {
    @Mapping(target = "id", ignore = true)
    Device map(DeviceAdditionDto deviceAddition);
}