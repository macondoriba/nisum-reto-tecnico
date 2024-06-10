package com.nisum.reto.application.mapper;

import com.nisum.reto.domain.model.RegularExpresion;
import com.nisum.reto.domain.model.dto.request.RegularExpresionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegularExpresionRequestMapper {
    @Mapping(source = "code", target = "code")
    @Mapping(source = "expression", target = "expression")
    RegularExpresion toDomain(RegularExpresionRequest request);
}