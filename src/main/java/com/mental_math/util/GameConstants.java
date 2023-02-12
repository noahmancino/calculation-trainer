package com.mental_math.util;

public class GameConstants {
    public enum Difficulty {
        BEGINNER,
        EASY,
        NORMAL,
        HARD,
        VERY_HARD
    }

    // Binary integer operation problems
    public static final int MAX_PROBLEM_OPERAND_INTEGER = (int) Math.pow(2, 15);

    public static final int MIN_GENERATED_PROBLEMS = 1;
    public static final int MAX_GENERATED_PROBLEMS = 50;
}
