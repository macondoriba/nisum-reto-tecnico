package com.nisum.reto.domain.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nisum.reto.domain.constant.UserConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegularExpressionResponse {
    private Long id;
    @JsonFormat(pattern = UserConstant.FORMAT_DATE_TIME)
    private LocalDateTime created;
    @JsonFormat(pattern = UserConstant.FORMAT_DATE_TIME)
    private LocalDateTime modified;
}
