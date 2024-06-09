package com.nisum.reto.infraestructure.adapter.mapper;

import com.nisum.reto.domain.model.User;
import com.nisum.reto.infraestructure.adapter.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDboMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "phones", target = "phones")
    @Mapping(source = "created", target = "created")
    @Mapping(source = "modified", target = "modified")
    @Mapping(source = "lastLogin", target = "lastLogin")
    @Mapping(source = "token", target = "token")
    @Mapping(source = "isActive", target = "isActive")


    UserEntity toDbo(User domain);

    @InheritInverseConfiguration
    User toDomain(UserEntity entity);

}
