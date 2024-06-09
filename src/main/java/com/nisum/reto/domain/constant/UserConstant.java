package com.nisum.reto.domain.constant;

public class UserConstant {
    public static final String EMAIL_REGULAR_EXPRESSION = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String PASSWORD_REGULAR_EXPRESSION = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";

    public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static final String EMAIL_ADDRESS_ALREADY_EXISTS = "Email address already exists : %s";

}
