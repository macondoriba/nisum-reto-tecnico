package com.nisum.reto.application.port.in;

import com.nisum.reto.domain.model.dto.request.RegularExpresionRequest;
import com.nisum.reto.domain.model.dto.response.RegularExpressionResponse;
import java.util.UUID;

public interface RegularExpressionWebPort {
    RegularExpressionResponse createNew(RegularExpresionRequest request);
    void delete(UUID id);
}
