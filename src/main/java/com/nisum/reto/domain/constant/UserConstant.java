package com.nisum.reto.domain.constant;

public class UserConstant {
    public final static String BEARER = "Bearer ";
    public final static String EMAIL_ADDRESS_REGULAR_EXPRESSION = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    public final static String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public final static String CODE_EXPRESSION_PASSWORD = "01";
    public final static String EMAIL_ADDRESS_ALREADY_EXISTS = "Email address  %s already exists.";
    public final static String EMAIL_ADDRESS_INVALID_FORMAT = "Invalid email address format. ";
    public final static String PASSWORD_REGULAR_EXPRESSION_INVALID_FORMAT = "Invalid password format. ";
    public final static String ACCESS_TOKEN_SECRET = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";
    public final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

}
