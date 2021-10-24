package com.techlearn.lambda.functionalinterface;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorUnitTest {

    @Test
    void unaryOperator() {
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();

        assertEquals("ABC", u1.apply("abc"));

        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);

        assertEquals("chickenchick", b1.apply("chicken", "chick"));
        assertEquals("chickenchick", b2.apply("chicken", "chick"));
    }

    @Test
    void binaryOperator() {
        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);

        assertEquals("chickenchick", b1.apply("chicken", "chick"));
        assertEquals("chickenchick", b2.apply("chicken", "chick"));
    }
}
