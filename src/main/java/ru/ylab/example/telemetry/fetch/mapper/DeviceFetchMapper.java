package ru.ylab.example.telemetry.fetch.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ylab.example.telemetry.fetch.model.DeviceFetchDto;
import ru.ylab.example.telemetry.share.Device;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeviceFetchMapper {
    DeviceFetchDto map(Device device);
}