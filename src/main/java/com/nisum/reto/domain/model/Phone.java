package com.nisum.reto.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Phone {
    private Long id;
    private UUID idUser;
    private String number;
    private String cityCode;
    private String countryCode;
}
