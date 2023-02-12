package com.example.mental_math.service

import com.mental_math.util.GameConstants
import org.springframework.web.server.ResponseStatusException
import com.mental_math.util.GameConstants.Difficulty;
import spock.lang.Specification
import com.mental_math.service.ProblemGeneratorService

// TODO: implement verifyBinOpResults test
class ProblemGeneratorServiceSpec extends Specification {
    ProblemGeneratorService problemGeneratorService;

    def setup() {
        problemGeneratorService = new ProblemGeneratorService();
    }

    def "generateAdditionProblems | valid input | valid response"() {
        when:
        def result = problemGeneratorService.generateAdditionProblems(level, numOfProbs)

        then:
        ProblemGeneratorService.verifyBinOpResults(result, Integer::sum)

        where:
        level                            | numOfProbs
        Difficulty.BEGINNER.toString()   | 1
        Difficulty.EASY.toString()       | 10
        Difficulty.NORMAL.toString()     | 10
        Difficulty.HARD.toString()       | 50
        Difficulty.VERY_HARD.toString()  | 10
    }

    def "generateSubtractionProblems | valid input | valid response"() {
        when:
        def result = problemGeneratorService.generateSubtractionProblems(level, numOfProbs)

        then:
        ProblemGeneratorService.verifyBinOpResults(result, (a, b) -> a - b)

        where:
        level                            | numOfProbs
        Difficulty.BEGINNER.toString()   | 1
        Difficulty.EASY.toString()       | 10
        Difficulty.NORMAL.toString()     | 10
        Difficulty.HARD.toString()       | 50
        Difficulty.VERY_HARD.toString()  | 10
    }

    def "generateMultiplicationProblems | valid input | valid response"() {
        when:
        def result = problemGeneratorService.generateMultiplicationProblems(level, numOfProbs)

        then:
        ProblemGeneratorService.verifyBinOpResults(result, (a, b) -> a * b)

        where:
        level                            | numOfProbs
        Difficulty.BEGINNER.toString()   | 1
        Difficulty.EASY.toString()       | 10
        Difficulty.NORMAL.toString()     | 10
        Difficulty.HARD.toString()       | 50
        Difficulty.VERY_HARD.toString()  | 10
    }

    def "generateDivisionProblems | valid input | valid response"() {
        when:
        def result = problemGeneratorService.generateDivisionProblems(level, numOfProbs)

        then:
        ProblemGeneratorService.verifyBinOpResults(result, (a, b) -> (a / b).intValue())

        where:
        level                            | numOfProbs
        Difficulty.BEGINNER.toString()   | 1
        Difficulty.EASY.toString()       | 10
        Difficulty.NORMAL.toString()     | 10
        Difficulty.HARD.toString()       | 50
        Difficulty.VERY_HARD.toString()  | 10
    }

    def "generateAdditionProblems | invalid input | throws ResponseStatusException"() {
            when:
            def result = problemGeneratorService.generateAdditionProblems(level, numOfProbs)

            then:
            def exception = thrown(ResponseStatusException);

            and:
            exception.getMessage() != null

        where:
        level                            | numOfProbs
        Difficulty.BEGINNER.toString()   | GameConstants.MAX_GENERATED_PROBLEMS + 1
        Difficulty.EASY.toString()       | GameConstants.MIN_GENERATED_PROBLEMS - 1
        "easy"                           | GameConstants.MIN_GENERATED_PROBLEMS - 1
        ""                               | 50
        "Ferocius"                       | 10
    }

    def "generateDivisionProblems | invalid input | throws ResponseStatusException"() {
        when:
        def result = problemGeneratorService.generateDivisionProblems(level, numOfProbs)

        then:
        def exception = thrown(ResponseStatusException);

        and:
        exception.getMessage() != null

        where:
        level                            | numOfProbs
        Difficulty.BEGINNER.toString()   | GameConstants.MAX_GENERATED_PROBLEMS + 1
        Difficulty.EASY.toString()       | GameConstants.MIN_GENERATED_PROBLEMS - 1
        "easy"                           | GameConstants.MIN_GENERATED_PROBLEMS - 1
        ""                               | 50
        "Ferocius"                       | 10
    }
}
