package com.nisum.reto.infraestructure.adapter.in.web.rest.controller;

import com.nisum.reto.application.usecase.RegularExpressionUseCase;
import com.nisum.reto.domain.model.dto.request.RegularExpresionRequest;
import com.nisum.reto.domain.model.dto.response.RegularExpressionResponse;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/regexp")
public class RegularExpressionController {
    private final RegularExpressionUseCase regularExpressionUseCase;
    public RegularExpressionController(RegularExpressionUseCase regularExpressionUseCase) {
        this.regularExpressionUseCase = regularExpressionUseCase;
    }

    @PostMapping()
    public RegularExpressionResponse create(@RequestBody RegularExpresionRequest regularExpressionRequest){
        return regularExpressionUseCase.createNew(regularExpressionRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        regularExpressionUseCase.delete(id);
    }
}
