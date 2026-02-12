package ru.ylab.example.telemetry.list.mapper;

import org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ylab.example.telemetry.list.model.DeviceDto;
import ru.ylab.example.telemetry.list.model.DeviceListDto;
import ru.ylab.example.telemetry.list.model.DeviceListResponse;
import ru.ylab.example.telemetry.share.Device;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeviceListMapper {

    DeviceDto map(Device device);

    DeviceListResponse map(DeviceListDto deviceList);

    default DeviceListDto map(List<Device> devices) {
        if (CollectionUtils.isEmpty(devices)) {
            return new DeviceListDto(List.of());
        }
        List<DeviceDto> deviceDtos = devices
                .stream()
                .map(this::map)
                .toList();
        return new DeviceListDto(deviceDtos);
    }
}