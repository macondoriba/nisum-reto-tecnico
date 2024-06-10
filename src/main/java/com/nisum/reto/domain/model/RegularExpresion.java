package com.nisum.reto.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegularExpresion {
    private Long id;
    private String code;
    private String expression;
    private LocalDateTime created;
    private LocalDateTime modified;
}