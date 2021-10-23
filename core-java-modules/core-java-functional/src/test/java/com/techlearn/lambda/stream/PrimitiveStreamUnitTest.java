package com.techlearn.lambda.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamUnitTest {

    @Test
    void primitiveStream() {
        IntStream count = IntStream.iterate(1, n -> n+1).limit(5);
        IntStream rangeClosed = IntStream.rangeClosed(1, 5);

        DoubleStream varargs = DoubleStream. of (1.0, 1.1, 1.2);
        DoubleStream random = DoubleStream. generate (Math::random);

        LongStream longStream = LongStream.of(1L, 2L);

        //Average
        IntStream stream = IntStream.rangeClosed(1,10);
        OptionalDouble optional = stream.average();
        System.out.println(optional.getAsDouble());
    }

    @Test
    void summaryStatistic() {
        IntStream rangeClosed = IntStream.rangeClosed(1, 5);
        IntSummaryStatistics intSummaryStatistics = rangeClosed.summaryStatistics();
        Assertions.assertEquals(1, intSummaryStatistics.getMin());
        Assertions.assertEquals(5, intSummaryStatistics.getMax());
        Assertions.assertEquals(3.0, intSummaryStatistics.getAverage());
    }
}
