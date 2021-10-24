package com.techlearn.lambda.functionalinterface;

import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredicateUnitTest {

    @Test
    void createPredicate() {
        Predicate<String> stringPredicate = String::isEmpty;
        Predicate<String> stringPredicate1 = s -> s.isEmpty();

        assertEquals(false, stringPredicate.test("test"));
        assertEquals(true, stringPredicate1.test(""));
    }

    @Test
    void createBiPredicate() {
        BiPredicate<String, String> b1 = String::startsWith;
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
        assertEquals(true, b1.test("chicken", "chick"));
        assertEquals(true, b2.test("chicken", "chick"));
    }

    @Test
    void defaultMethodInPredicate() {
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
        Predicate<String> otherEggs = s -> s.contains("egg") && ! s.contains("brown");

        Predicate<String> brownEggs1 = egg.and(brown);
        Predicate<String> otherEggs1 = egg.and(brown.negate());

        assertEquals(true, brownEggs.test("brown-egg"));
        assertEquals(true, otherEggs1.test("white-egg"));
    }
}
