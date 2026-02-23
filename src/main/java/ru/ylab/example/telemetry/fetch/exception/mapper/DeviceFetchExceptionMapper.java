package ru.ylab.example.telemetry.fetch.exception.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ylab.example.telemetry.fetch.exception.model.DeviceFetchExceptionResponse;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeviceFetchExceptionMapper {
    DeviceFetchExceptionResponse map(String message);
}