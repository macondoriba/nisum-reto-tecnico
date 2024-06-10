package com.nisum.reto.infraestructure.adapter.framework.regularexpresions;

import com.nisum.reto.domain.constant.UserConstant;
import com.nisum.reto.domain.port.RegularExpresionFrameworkPort;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class UserRegExAdapter implements RegularExpresionFrameworkPort {

    @Override
    public boolean validateRegularExpresionEmail(String email) {
        return Pattern.compile(UserConstant.EMAIL_ADDRESS_REGULAR_EXPRESSION)
                .matcher(email)
                .matches();
    }

    @Override
    public boolean validateRegularExpresionPassword(String regularExpresion, String password) {
        return Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
                .matcher(password)
                .matches();
    }

}

