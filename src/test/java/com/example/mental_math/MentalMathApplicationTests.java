package com.example.mental_math;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
class MentalMathApplicationTests {

    @Test
    void contextLoads() {
    }

}
