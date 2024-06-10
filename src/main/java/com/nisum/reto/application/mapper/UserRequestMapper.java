package com.nisum.reto.application.mapper;

import com.nisum.reto.domain.model.User;
import com.nisum.reto.domain.model.dto.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "phones", target = "phones")
    User toDomain(UserRequest request);
}