package com.nisum.reto.infraestructure.adapter.in.framework.regularexpresions;

import com.nisum.reto.application.util.constants.UserConstant;
import com.nisum.reto.application.port.in.RegularExpresionFrameworkPort;
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

