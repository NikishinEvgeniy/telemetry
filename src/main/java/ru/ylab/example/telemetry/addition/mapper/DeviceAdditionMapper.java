package ru.ylab.example.telemetry.addition.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ylab.example.telemetry.addition.model.DeviceAdditionDto;
import ru.ylab.example.telemetry.addition.model.DeviceAdditionRequest;
import ru.ylab.example.telemetry.share.Device;

@Mapper( unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeviceAdditionMapper {
    @Mapping(target = "id", ignore = true)
    Device map(DeviceAdditionDto deviceAddition);
    DeviceAdditionDto map(DeviceAdditionRequest request);
}