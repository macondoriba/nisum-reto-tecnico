package com.nisum.reto.domain.constant;

public class UserConstant {
    public static final String BEARER = "Bearer ";
    public static final String EMAIL_ADDRESS_REGULAR_EXPRESSION = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String CODE_EXPRESSION_PASSWORD = "01";
    public static final String EMAIL_ADDRESS_ALREADY_EXISTS = "Email address  %s already exists.";
    public static final String EMAIL_ADDRESS_INVALID_FORMAT = "Invalid email address format. ";
    public static final String PASSWORD_REGULAR_EXPRESSION_INVALID_FORMAT = "Invalid password format. ";

}
