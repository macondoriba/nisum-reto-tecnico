package com.nisum.reto.infraestructure.adapter.out.persistence.mapper;

import com.nisum.reto.domain.model.RegularExpresion;
import com.nisum.reto.infraestructure.adapter.out.persistence.entity.RegularExpresionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegularExpresionDboMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "expression", target = "expression")
    @Mapping(source = "created", target = "created")
    @Mapping(source = "modified", target = "modified")
    RegularExpresionEntity toDbo(RegularExpresion domain);

    @InheritInverseConfiguration
    RegularExpresion toDomain(RegularExpresionEntity entity);

}
