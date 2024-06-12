package com.nisum.reto.application.util.mapper;

import com.nisum.reto.domain.model.RegularExpresion;
import com.nisum.reto.domain.model.dto.response.RegularExpressionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegularExpresionResponseMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "created", target = "created")
    @Mapping(source = "modified", target = "modified")
    RegularExpressionResponse toResponse(RegularExpresion domain);
}
