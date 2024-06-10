package com.nisum.reto.application.usecases;

import com.nisum.reto.domain.model.dto.request.RegularExpresionRequest;
import com.nisum.reto.domain.model.dto.response.RegularExpressionResponse;
import java.util.UUID;

public interface RegularExpressionUseCase {
    RegularExpressionResponse createNew(RegularExpresionRequest request);
    void delete(UUID id);
}
