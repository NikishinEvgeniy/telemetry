package ru.ylab.example.telemetry.edit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ylab.example.telemetry.edit.model.DeviceEditDto;
import ru.ylab.example.telemetry.edit.model.DeviceEditRequest;
import ru.ylab.example.telemetry.share.Device;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeviceEditMapper {
    Device map(DeviceEditDto deviceEdit);
    DeviceEditDto map(Long id, DeviceEditRequest deviceEditRequest);
}