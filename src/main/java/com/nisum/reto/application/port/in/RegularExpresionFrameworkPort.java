package com.nisum.reto.application.port.in;

public interface RegularExpresionFrameworkPort {
    boolean validateRegularExpresionEmail(String email);
    boolean validateRegularExpresionPassword(String regularExpresion, String password);
}
