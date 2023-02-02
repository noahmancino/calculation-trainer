package com.example.mental_math.service

import spock.lang.Specification
import com.mental_math.service.ProblemGeneratorService

// TODO: implement verifyBinOpResults test
class ProblemGeneratorServiceSpec extends Specification {
    def "generateAdditionProblems"() {
        when:
        def result = ProblemGeneratorService.generateAdditionProblems(op1, op2)

        then:
        ProblemGeneratorService.verifyBinOpResults(result, Integer::sum)

        where:
        op1 | op2
        1   | 1
        25  | 10
        10  | 10
        40  | 50
    }

    def "generateSubtractionProblems"() {
        when:
        def result = ProblemGeneratorService.generateSubtractionProblems(op1, op2)

        then:
        ProblemGeneratorService.verifyBinOpResults(result, (a, b) -> a - b)

        where:
        op1 | op2
        1   | 1
        25  | 10
        10  | 10
        40  | 50
    }

    def "verifyBinOpResults"() {
        given:
        boolean a = true

        then:
        a = true
    }
}
