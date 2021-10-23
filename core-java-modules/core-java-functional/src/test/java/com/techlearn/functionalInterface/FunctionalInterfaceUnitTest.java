package com.techlearn.functionalInterface;

import static org.junit.jupiter.api.Assertions.*;

import com.techlearn.lambda.functioninterface.TriFunction;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.*;

/**
 * FunctionalInterfaces    # Parameters    ReturnType    Single Abstract Method
 * Supplier<T>              0               T               get
 * Consumer<T>              1(T)            void            accept
 * BiConsumer<T, U>         2 (T, U)        void            accept
 * Predicate<T>             1 (T)           boolean         test
 * BiPredicate<T, U>        2 (T, U)        boolean         test
 * Function<T, R>           1 (T)           R               apply
 * BiFunction<T, U, R>      2 (T, U)        R               apply
 * UnaryOperator<T>         1 (T)           T               apply
 * BinaryOperator<T>        2 (T, T)        T               apply
 */
public class FunctionalInterfaceUnitTest {
    @Test
    void createSupplier() {
        Supplier<String> stringSupplier = () -> UUID.randomUUID().toString();
        Supplier<LocalDate> localDateSupplier = LocalDate::now;

        Assertions.assertNotNull(stringSupplier.get());
        Assertions.assertNotNull(localDateSupplier.get());
    }

    @Test
    void createConsumer() {
        Consumer<String> stringConsumer = System.out::println;
        Consumer<String> stringConsumer1 = s -> System.out.println(s);

        stringConsumer.accept("Print Me");
        stringConsumer1.accept("Print Me 111");
    }

    @Test
    void createBiConsumer() {
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> b1 = map::put;
        b1.accept("name",12);

        assertEquals(12, map.get("name"));
    }

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
