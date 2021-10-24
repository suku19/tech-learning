package com.techlearn.lambda.functionalinterface;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumerUnitTest {

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
}
