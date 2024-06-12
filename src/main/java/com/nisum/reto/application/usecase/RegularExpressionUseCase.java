package com.nisum.reto.application.usecase;

import com.nisum.reto.application.util.mapper.RegularExpresionRequestMapper;
import com.nisum.reto.application.util.mapper.RegularExpresionResponseMapper;
import com.nisum.reto.application.port.in.RegularExpressionWebPort;
import com.nisum.reto.domain.model.dto.request.RegularExpresionRequest;
import com.nisum.reto.domain.model.dto.response.RegularExpressionResponse;
import com.nisum.reto.application.port.out.RegularExpresionPersistencePort;
import com.nisum.reto.application.util.constants.RegularExpressionConstant;
import com.nisum.reto.infraestructure.adapter.util.exception.RegularExpressionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RegularExpressionUseCase implements RegularExpressionWebPort {

    private final RegularExpresionPersistencePort regularExpresionPersistencePort;
    private final RegularExpresionRequestMapper regularExpresionRequestMapper;
    private final RegularExpresionResponseMapper regularExpresionResponseMapper;

    @Autowired
    public RegularExpressionUseCase(RegularExpresionPersistencePort regularExpresionPersistencePort,
                                    RegularExpresionRequestMapper regularExpresionRequestMapper,
                                    RegularExpresionResponseMapper regularExpresionResponseMapper) {
        this.regularExpresionPersistencePort = regularExpresionPersistencePort;
        this.regularExpresionRequestMapper = regularExpresionRequestMapper;
        this.regularExpresionResponseMapper = regularExpresionResponseMapper;
    }

    @Override
    public RegularExpressionResponse createNew(RegularExpresionRequest request) {
        var expresions = regularExpresionPersistencePort.getAll()
                .stream()
                .filter(p->p.getCode().equals(request.getCode()))
                .collect(Collectors.toList());
        if(!expresions.isEmpty()){
            regularExpresionPersistencePort.deleteById(expresions.get(0).getId());
        }
        var expresionToSave = regularExpresionRequestMapper.toDomain(request);
        var expresionCreated = regularExpresionPersistencePort.create(expresionToSave);
        return regularExpresionResponseMapper.toResponse(expresionCreated);
    }

    @Override
    public void delete(UUID id) {
        var expression = regularExpresionPersistencePort.getById(id);
        if(expression==null){
            throw new RegularExpressionException(HttpStatus.BAD_REQUEST,
                    String.format(RegularExpressionConstant.CURRENT_REGULAR_EXPRESSION_NOT_ALLOW_TO_DELETE));
        }
        regularExpresionPersistencePort.deleteById(id);
    }
}
