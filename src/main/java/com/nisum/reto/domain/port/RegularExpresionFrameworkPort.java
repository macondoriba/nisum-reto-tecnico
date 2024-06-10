package com.nisum.reto.domain.port;

public interface RegularExpresionFrameworkPort {
    boolean validateRegularExpresionEmail(String email);
    boolean validateRegularExpresionPassword(String password, String regularExpresion);
}
