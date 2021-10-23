package com.techlearn.lambda.methodreference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private Integer grade;

    public Student(String s) {
        this.name = s;
    }
}
