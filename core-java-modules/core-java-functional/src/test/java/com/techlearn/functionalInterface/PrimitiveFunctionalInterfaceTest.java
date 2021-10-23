package com.techlearn.functionalInterface;


import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

public class PrimitiveFunctionalInterfaceTest {

    @Test
    void functionalInterfacesForPrimitives() {
        BooleanSupplier b2 = () -> Math.random() > .5;
        System.out.println( b2.getAsBoolean());
    }
}
