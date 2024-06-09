package com.nisum.reto.infraestructure.rest.advice;

import com.nisum.reto.infraestructure.adapter.exception.UserException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControlAdvice {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> handleEmptyInput(UserException emptyInputException){
        JSONObject resp = new JSONObject();
        resp.put("mensaje",emptyInputException.getErrorMessage());
        return new ResponseEntity<>(resp.toString(), emptyInputException.getErrorCode());
    }
}
