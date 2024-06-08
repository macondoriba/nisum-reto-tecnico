package com.nisum.reto.domain.model.request;

import lombok.*;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private List<PhoneRequest> phones;
}