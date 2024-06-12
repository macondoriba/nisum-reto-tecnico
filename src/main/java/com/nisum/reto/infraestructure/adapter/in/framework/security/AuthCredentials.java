package com.nisum.reto.infraestructure.adapter.in.framework.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
