package com.techlearn.lambda.functionalinterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Supplier;

public class SupplierUnitTest {
    @Test
    void createSupplier() {
        Supplier<String> stringSupplier = () -> UUID.randomUUID().toString();
        Supplier<LocalDate> localDateSupplier = LocalDate::now;

        Assertions.assertNotNull(stringSupplier.get());
        Assertions.assertNotNull(localDateSupplier.get());
    }
}
