package com.nisum.reto.domain.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.reto.application.util.constants.UserConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private UUID id;
    @JsonFormat(pattern = UserConstant.FORMAT_DATE_TIME)
    private LocalDateTime created;
    @JsonFormat(pattern = UserConstant.FORMAT_DATE_TIME)
    private LocalDateTime modified;
    @JsonProperty("last_login")
    private LocalDateTime lastLogin;
    private String token;
    @JsonProperty("isactive")
    private Boolean isActive;

}