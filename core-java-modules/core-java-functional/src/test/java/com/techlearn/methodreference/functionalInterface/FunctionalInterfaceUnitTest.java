package com.techlearn.methodreference.functionalInterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

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

        Assertions.assertEquals(12, map.get("name"));
    }
}
