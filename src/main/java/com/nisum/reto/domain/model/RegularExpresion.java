package com.nisum.reto.domain.model;

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
public class RegularExpresion {
    private UUID id;
    private String code;
    private String expression;
    private LocalDateTime created;
    private LocalDateTime modified;
}