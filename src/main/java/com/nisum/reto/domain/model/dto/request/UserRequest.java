package com.nisum.reto.domain.model.dto.request;

import com.nisum.reto.domain.constant.UserConstant;
import lombok.*;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    private String name;
   // @Email(regexp= UserConstant.EMAIL_REGULAR_EXPRESSION, message =" Format incorrect")
    private String email;
    private String password;
    private List<PhoneRequest> phones;
}