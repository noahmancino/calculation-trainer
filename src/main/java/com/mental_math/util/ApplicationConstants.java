package com.mental_math.util;

import java.lang.Math;

public class ApplicationConstants {

    // Regex
    public static final String PASSWORD_PATTERN = "^[0-9a-zA-Z_.-!@]{1,30}$";
    public static final String USERNAME_PATTERN = "^[0-9a-zA-Z]{1,20}";


    // Magic numbers
    public static final int JWT_EXPIRATION_MILLIS = 1000 * 60 * 60 * 12;
}
