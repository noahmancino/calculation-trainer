package com.mental_math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MentalMathApplication {

    public static void main(String[] args) {
        SpringApplication.run(MentalMathApplication.class, args);
    }
}
