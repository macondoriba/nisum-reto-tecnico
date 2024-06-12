package com.nisum.reto.application.util.mapper;

import com.nisum.reto.domain.model.Phone;
import com.nisum.reto.domain.model.dto.request.PhoneRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhoneRequestMapper {
    @Mapping(source = "number", target = "number")
    @Mapping(source = "cityCode", target = "cityCode")
    @Mapping(source = "countryCode", target = "countryCode")
    Phone toDomain(PhoneRequest request);
}