package com.example.mental_math.service

import org.springframework.web.server.ResponseStatusException
import spock.lang.Specification
import com.mental_math.service.ProblemGeneratorService

// TODO: implement verifyBinOpResults test
class ProblemGeneratorServiceSpec extends Specification {
    def "generateAdditionProblems | valid input | valid response"() {
        when:
        def result = ProblemGeneratorService.generateAdditionProblems(maxNum, numOfProbs)

        then:
        ProblemGeneratorService.verifyBinOpResults(result, Integer::sum)

        where:
        maxNum | numOfProbs
        1   | 1
        25  | 10
        10  | 10
        40  | 50
    }

    def "generateSubtractionProblems | valid input | valid response"() {
        when:
        def result = ProblemGeneratorService.generateSubtractionProblems(maxNum, numOfProbs)

        then:
        ProblemGeneratorService.verifyBinOpResults(result, (a, b) -> a - b)

        where:
        maxNum | numOfProbs
        1   | 1
        25  | 10
        10  | 10
        40  | 50
    }

    def "generateMultiplicationProblems | valid input | valid response"() {
        when:
        def result = ProblemGeneratorService.generateMultiplicationProblems(maxNum, numOfProbs)

        then:
        ProblemGeneratorService.verifyBinOpResults(result, (a, b) -> a * b)

        where:
        maxNum | numOfProbs
        1   | 1
        25  | 10
        10  | 10
        40  | 50
    }

    def "generateDivisionProblems | valid input | valid response"() {
        when:
        def result = ProblemGeneratorService.generateDivisionProblems(maxNum, numOfProbs)

        then:
        ProblemGeneratorService.verifyBinOpResults(result, (a, b) -> (a / b).intValue())

        where:
        maxNum | numOfProbs
        1   | 1
        25  | 10
        10  | 10
        40  | 50
    }

    def "generateAdditionProblem | invalid input | throws ResponseStatusException"() {
            when:
            def result = ProblemGeneratorService.generateAdditionProblems(maxNum, numOfProbs)

            then:
            def exception = thrown(ResponseStatusException);

            and:
            exception.getMessage() != null

            where:
            maxNum | numOfProbs
            0   | 0
            0   | 10
            (int) Math.pow(2, 15) + 1  | 10
            10  | 0
            10 | 51
    }
}
