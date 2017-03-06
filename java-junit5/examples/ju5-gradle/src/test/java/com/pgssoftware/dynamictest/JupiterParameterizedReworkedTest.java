package com.pgssoftware.dynamictest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static com.pgssoftware.dynamictest.JupiterParameterizedReworkedTest.FibTestCase.of;
import static java.lang.String.format;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class JupiterParameterizedReworkedTest {

    public static class FibTestCase {
        public int input;
        public int expected;

        static FibTestCase of(int input, int expected) {
            FibTestCase backpack = new FibTestCase();
            backpack.input = input;
            backpack.expected = expected;
            return backpack;
        }
    }

    @TestFactory
    Stream<DynamicTest> fibonacciTestFactory() {
        return Stream.of(new FibTestCase[]{
                of(0, 0),
                of(1, 1),
                of(2, 1),
                of(3, 2),
                of(4, 3),
                of(5, 5),
                of(6, 8)})
                .map(this::test);
    }

    private DynamicTest test(FibTestCase i) {
        return dynamicTest(format("input={%d}, expected={%d}", i.input, i.expected),
                () -> {
                    Assert.assertEquals(i.expected, Fibonacci.compute(i.input));
                });
    }

    @Test
    public void test2() {

    }

    private static class Fibonacci {
        public static int compute(int n) {
            int result = 0;

            if (n <= 1) {
                result = n;
            } else {
                result = compute(n - 1) + compute(n - 2);
            }

            return result;
        }
    }
}
