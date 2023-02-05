package com.mental_math.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinaryIntegerOperation implements Serializable {
    private int op1;
    private int op2;
    private int result;
}
