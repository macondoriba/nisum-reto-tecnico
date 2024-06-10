package com.nisum.reto.infraestructure.adapter.persistence;

import com.nisum.reto.domain.constant.RegularExpressionConstant;
import com.nisum.reto.domain.model.RegularExpresion;
import com.nisum.reto.domain.port.RegularExpresionPersistencePort;
import com.nisum.reto.infraestructure.adapter.exception.RegularExpressionException;
import com.nisum.reto.infraestructure.adapter.persistence.mapper.RegularExpresionDboMapper;
import com.nisum.reto.infraestructure.adapter.persistence.repository.RegularExpresionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegularExpresionSpringJpaAdapter implements RegularExpresionPersistencePort {

    private final RegularExpresionRepository regularExpresionRepository;
    private final RegularExpresionDboMapper regularExpresionDboMapper;

    public RegularExpresionSpringJpaAdapter(RegularExpresionRepository regularExpresionRepository,
                                            RegularExpresionDboMapper regularExpresionDboMapper) {
        this.regularExpresionRepository = regularExpresionRepository;
        this.regularExpresionDboMapper = regularExpresionDboMapper;
    }

    @Override
    public RegularExpresion create(RegularExpresion expresion) {
        var expresionToSave = regularExpresionDboMapper.toDbo(expresion);
        var expresionSaved = regularExpresionRepository.save(expresionToSave);

        return regularExpresionDboMapper.toDomain(expresionSaved);
    }

    @Override
    public List<RegularExpresion> getAll() {
        return regularExpresionRepository.findAll()
                .stream()
                .map(regularExpresionDboMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public RegularExpresion getById(Long id) {
        var optionalExpresion = regularExpresionRepository.findById(id);
        if (optionalExpresion.isEmpty()){
            throw new RegularExpressionException(HttpStatus.NOT_FOUND, String.format(RegularExpressionConstant.REGULAR_EXPRESSION_NOT_FOUND_MESSAGE_ERROR));
        }
        return regularExpresionDboMapper.toDomain(optionalExpresion.get());
    }

    @Override
    public void deleteById(Long id) {
        regularExpresionRepository.deleteById(id);
    }


}
