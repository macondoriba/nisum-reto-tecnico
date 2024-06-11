package com.nisum.reto.infraestructure.adapter.framework.regularexpresions;

import com.nisum.reto.domain.constant.UserConstant;
import com.nisum.reto.domain.port.RegularExpresionFrameworkPort;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class UserRegExAdapter implements RegularExpresionFrameworkPort {

    @Override
    public boolean validateRegularExpresionEmail(String email) {
        return  Pattern.compile(UserConstant.EMAIL_ADDRESS_REGULAR_EXPRESSION)
                .matcher(email)
                .find();
    }

    @Override
    public boolean validateRegularExpresionPassword(String password, String regularExpresion) {
        return Pattern.compile(regularExpresion)
                .matcher(password)
                .find();
    }

}

