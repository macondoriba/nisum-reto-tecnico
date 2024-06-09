package com.nisum.reto.infraestructure.rest.advice;

import com.nisum.reto.domain.model.dto.response.ErrorResponse;
import com.nisum.reto.infraestructure.adapter.exception.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControlAdvice {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> handleEmptyInput(UserException ex){
        ErrorResponse error = new ErrorResponse(ex.getErrorMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
