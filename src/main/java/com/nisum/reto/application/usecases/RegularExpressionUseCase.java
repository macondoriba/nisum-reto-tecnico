package com.nisum.reto.application.usecases;

import com.nisum.reto.domain.model.dto.request.RegularExpresionRequest;
import com.nisum.reto.domain.model.dto.response.RegularExpressionResponse;

public interface RegularExpressionUseCase {
    RegularExpressionResponse createNew(RegularExpresionRequest request);
    void delete(Long id);
}
