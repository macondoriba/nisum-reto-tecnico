package com.nisum.reto.infraestructure.adapter.rest.controller;

import com.nisum.reto.application.service.RegularExpressionService;
import com.nisum.reto.domain.model.dto.request.RegularExpresionRequest;
import com.nisum.reto.domain.model.dto.response.RegularExpressionResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/regexp")
public class RegularExpressionController {
    private final RegularExpressionService regularExpressionService;
    public RegularExpressionController(RegularExpressionService regularExpressionService) {
        this.regularExpressionService = regularExpressionService;
    }

    @PostMapping()
    public RegularExpressionResponse create(@RequestBody RegularExpresionRequest regularExpressionRequest){
        return regularExpressionService.createNew(regularExpressionRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        regularExpressionService.delete(id);
    }
}
