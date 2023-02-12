package com.mental_math.service;

import com.mental_math.model.BinaryIntegerOperation;
import com.mental_math.util.GameConstants;
import com.mental_math.util.GameConstants.Difficulty;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@Service
@AllArgsConstructor
public class ProblemGeneratorService {

    /**
     * @param level difficulty of problems
     * @param numOfProblems Size of generated list
     * @return A random list of BinaryIntegerOperations where op1 + op2 = result.
     */
    public List<BinaryIntegerOperation> generateAdditionProblems(String level, int numOfProblems) {
        int maxNum = mapBinaryIntegerProblemLevel(level);
        validateBinaryIntegerProblems(maxNum, numOfProblems);
        return generateBinaryIntegerProblems(maxNum, numOfProblems, (a, b) -> a + b);
    }

    /**
     * @param level difficulty of problems
     * @param numOfProblems Size of generated list
     * @return A random list of BinaryIntegerOperations where op1 - op2 = result.
     */
    public List<BinaryIntegerOperation> generateSubtractionProblems(String level, int numOfProblems) {
        int maxNum = mapBinaryIntegerProblemLevel(level);
        validateBinaryIntegerProblems(maxNum, numOfProblems);
        return generateBinaryIntegerProblems(maxNum, numOfProblems, (a, b) -> a - b);
    }

    /**
     * @param level difficulty of problems
     * @param numOfProblems Size of generated list
     * @return A random list of BinaryIntegerOperations where op1 * op2 = result.
     */
    public List<BinaryIntegerOperation> generateMultiplicationProblems(String level, int numOfProblems) {
        int maxNum = mapBinaryIntegerProblemLevel(level);
        validateBinaryIntegerProblems(maxNum, numOfProblems);
        return generateBinaryIntegerProblems(maxNum, numOfProblems, (a, b) -> a * b);
    }

    /**
     * This has to have its own implementation in order to guarantee the result is an integer
     * @param level difficulty of problems
     * @param numOfProblems Size of generated list
     * @return A random list of BinaryIntegerOperations where op1 / op2 = result.
     */
    public List<BinaryIntegerOperation> generateDivisionProblems(String level, int numOfProblems) {
        int maxNum = mapBinaryIntegerProblemLevel(level);
        validateBinaryIntegerProblems(maxNum, numOfProblems);
        List<BinaryIntegerOperation> divisionProblems = new ArrayList<>();
        for (int i = 0; i < numOfProblems; i++) {
            int divisor = getRandomNumber(1, maxNum);
            int result = getRandomNumber(0, maxNum);
            int dividend = divisor * result;
            divisionProblems.add(new BinaryIntegerOperation(dividend, divisor, result));
        }
        return divisionProblems;
    }


    private static List<BinaryIntegerOperation> generateBinaryIntegerProblems(
            int maxNum, int numOfProblems,
            BiFunction<Integer, Integer, Integer> biFunction) {
        List<BinaryIntegerOperation> problems = new ArrayList<>();
        for (int i = 0; i < numOfProblems; i++) {
            int op1 = getRandomNumber(0, maxNum);
            int op2 = getRandomNumber(0, maxNum);
            int result = biFunction.apply(op1, op2);
            problems.add(new BinaryIntegerOperation(op1, op2, result));
        }
        return problems;
    }

    private static List<Integer> getRandomNumberList(int min, int max, int numOfRandNums) {
        List<Integer> randomNums = new ArrayList<>();
        for (int i = 0; i < numOfRandNums; i++) {
            randomNums.add(getRandomNumber(min, max));
        }
        return randomNums;
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /*
    Validation for binary multiplication, division, addition, and subtraction. Despite the name not meant to generalize
    to all binary integer operations.
     */
    private static void validateBinaryIntegerProblems(int maxNum, int numOfProblems) {
        boolean isMaxNumValid = 0 < maxNum && maxNum < GameConstants.MAX_PROBLEM_OPERAND_INTEGER;
        boolean isNumOfProblemsValid =
                GameConstants.MIN_GENERATED_PROBLEMS <= numOfProblems && numOfProblems <= GameConstants.MAX_GENERATED_PROBLEMS;
        if (!isNumOfProblemsValid) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Too few or too many problems to be generated");
        }
        if (!isMaxNumValid) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Maximum operand size non-positive or too large.");
        }
    }

    /**
     * @param level of difficulty for problem
     * @return largest possible operand value for problem
     */
    private int mapBinaryIntegerProblemLevel(String level) {
        Difficulty difficulty;
        try {
            difficulty = Difficulty.valueOf(level);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid difficulty");
        }

        return switch (difficulty) {
            case BEGINNER -> 10;
            case EASY -> 20;
            case NORMAL -> 50;
            case HARD -> 100;
            case VERY_HARD -> 500;
            default -> throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problem difficulty should be 1-5");
        };
    }


    /**
     * Given a list of BinaryIntegerOperations object and function to mapping the two operands of the object to
     * the result, returns true if the output of the function output matches the result in for every
     * BinaryIntegerOperation and false otherwise.
     * @param binaryIntegerOperations List of binaryIntegerOperations to verify correctness of
     * @param binOp BiFunction to verify BinaryIntegerOperation.result field
     * @return true if binOp matches result in every case, false otherwise.
     */
    public static boolean verifyBinOpResults(List<BinaryIntegerOperation> binaryIntegerOperations,
                                      BiFunction<Integer, Integer, Integer> binOp) {
        for (BinaryIntegerOperation binaryIntegerOperation: binaryIntegerOperations) {
            if (binOp.apply(binaryIntegerOperation.getOp1(), binaryIntegerOperation.getOp2())
                    != binaryIntegerOperation.getResult()) {
                return false;
            }
        }
        return true;
    }
}
