package com.mental_math.service;

import com.mental_math.model.BinaryIntegerOperation;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@Service
public class ProblemGeneratorService {

    /* NOTE: make sure to validate in service before calling these as most of them are prone to throw exceptions given
    bad input
     */
    public static List<BinaryIntegerOperation> generateAdditionProblems(int maxNum, int numOfProblems) {
        List<BinaryIntegerOperation> generatedProblems = generateBinaryIntegerProblemOperands(maxNum, numOfProblems);
        for (BinaryIntegerOperation additionProblem: generatedProblems) {
            additionProblem.setResult(additionProblem.getOp1() + additionProblem.getOp2());
        }
        return generatedProblems;
    }

    public static List<BinaryIntegerOperation> generateSubtractionProblems(int maxNum, int numOfProblems) {
        List<BinaryIntegerOperation> generatedProblems = generateBinaryIntegerProblemOperands(maxNum, numOfProblems) ;
        for (BinaryIntegerOperation subtractionProblem: generatedProblems) {
            subtractionProblem.setResult(subtractionProblem.getOp1() - subtractionProblem.getOp2());
        }
        return generatedProblems;
    }

    private static List<BinaryIntegerOperation> generateBinaryIntegerProblemOperands(int maxNum, int numOfProblems) {

        List<BinaryIntegerOperation> generatedProblems = new ArrayList<>();
        List<Integer> operands = getRandomNumberList(0, maxNum, numOfProblems * 2);
        for (int i = 0; i < numOfProblems; i++) {
            BinaryIntegerOperation binaryIntegerOperation = new BinaryIntegerOperation();
            binaryIntegerOperation.setOp1(operands.get(i * 2));
            binaryIntegerOperation.setOp2(operands.get((i * 2) + 1));
            generatedProblems.add(binaryIntegerOperation);
        }
        return generatedProblems;
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

    // Functions for testing
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
