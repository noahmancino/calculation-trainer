package com.mental_math.controller;

import com.mental_math.model.BinaryIntegerOperation;

import com.mental_math.service.ProblemGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("api/v1/generate")
@Controller
@AllArgsConstructor
public class ProblemGeneratorController {
    private final ProblemGeneratorService problemGeneratorService;

    @GetMapping("/integer/addition")
    public ResponseEntity<List<BinaryIntegerOperation>> getAdditionProblems(
            @RequestHeader
            String level,
            @RequestHeader
            int numOfProblems
    ) {
        return ResponseEntity.ok(problemGeneratorService.generateAdditionProblems(level, numOfProblems));
    }

    @GetMapping("/integer/subtraction")
    public ResponseEntity<List<BinaryIntegerOperation>> getSubtractionProblems(
            @RequestHeader
            String level,
            @RequestHeader
            int numOfProblems
    ) {
        return ResponseEntity.ok(problemGeneratorService.generateSubtractionProblems(level, numOfProblems));
    }
    @GetMapping("/integer/multiplication")
    public ResponseEntity<List<BinaryIntegerOperation>> getMultiplicationProblems(
            @RequestHeader
            String level,
            @RequestHeader
            int numOfProblems
    ) {
        return ResponseEntity.ok(problemGeneratorService.generateMultiplicationProblems(level, numOfProblems));
    }

    @GetMapping("/integer/division")
    public ResponseEntity<List<BinaryIntegerOperation>> getDivisionProblems(
            @RequestHeader
            String level,
            @RequestHeader
            int numOfProblems
    ) {
        return ResponseEntity.ok(problemGeneratorService.generateDivisionProblems(level, numOfProblems));
    }
}
