package com.nisum.reto.infraestructure.rest.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorMessage {
    private HttpStatus errorCode;
    private String errorMessage;

}
