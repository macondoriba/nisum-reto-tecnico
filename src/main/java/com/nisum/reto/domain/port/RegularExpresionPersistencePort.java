package com.nisum.reto.domain.port;

import com.nisum.reto.domain.model.RegularExpresion;
import java.util.List;
import java.util.UUID;

public interface RegularExpresionPersistencePort {
    RegularExpresion create(RegularExpresion expresion);
    List<RegularExpresion> getAll();
    RegularExpresion getById(UUID id);
    void deleteById(UUID id);
}
