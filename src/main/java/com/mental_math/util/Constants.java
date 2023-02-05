package com.mental_math.util;

import java.lang.Math;

public class Constants {
    // Regex
    public static final String PASSWORD_PATTERN = "^[0-9a-zA-Z_.-!@]{1,30}$";
    public static final String USERNAME_PATTERN = "^[0-9a-zA-Z]{1,20}";


    // Magic numbers
    public static final int JWT_EXPIRATION_MILLIS = 1000 * 60 * 60 * 12;
    public static final int MAX_PROBLEM_OPERAND_INTEGER = (int) Math.pow(2, 15);
    public static final int MIN_GENERATED_PROBLEMS = 1;
    public static final int MAX_GENERATED_PROBLEMS = 50;
}
