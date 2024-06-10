package com.nisum.reto.domain.port;

import com.nisum.reto.domain.model.RegularExpresion;

import java.util.List;

public interface RegularExpresionPersistencePort {
    RegularExpresion create(RegularExpresion expresion);
    List<RegularExpresion> getAll();
    RegularExpresion getById(Long id);
    void deleteById(Long id);
}
