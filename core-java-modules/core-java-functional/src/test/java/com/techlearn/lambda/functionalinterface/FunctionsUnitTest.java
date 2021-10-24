package com.techlearn.lambda.functionalinterface;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionsUnitTest {

    @Test
    void createFunction() {
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();

        assertEquals(5, f1.apply("abcde"));
        assertEquals(5, f2.apply("12345"));
    }

    @Test
    void createBiFunction() {
        BiFunction<String, String, String> b1 = String::concat;
        BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);

        assertEquals("chickenchick", b1.apply("chicken", "chick"));
        assertEquals("chickenchick", b2.apply("chicken", "chick"));
    }


    @Test
    void userDefineFunction() {
        TriFunction<String,String,String,String> triFunction = StringUtils::join;

        assertEquals("ABC", triFunction.apply("A", "B", "C"));
    }
}
