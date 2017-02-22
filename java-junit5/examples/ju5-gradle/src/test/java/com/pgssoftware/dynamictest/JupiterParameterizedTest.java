package com.pgssoftware.dynamictest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static java.lang.String.format;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class JupiterParameterizedTest {

    @TestFactory
    Stream<DynamicTest> fibonacciTestFactory() {
        return Stream.of(new int[][] {{ 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }})
                .map(this::test);
    }

    private DynamicTest test(int[] i) {
        int input = i[0];
        int expected = i[1];
        return dynamicTest(format("input={%d}, expected={%d}", input, expected),
                () -> {
                    Assert.assertEquals(expected, Fibonacci.compute(input));
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
