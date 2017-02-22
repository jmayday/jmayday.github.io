package com.pgssoftware.dynamictest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;


public class JupiterMultipleFactoriesTest {

    @TestFactory
    List<DynamicTest> tests() {

        return Arrays.asList(
                DynamicTest.dynamicTest("1",() -> { Assertions.assertEquals(0,0,"text"); }),
                DynamicTest.dynamicTest("2",() -> { Assertions.assertEquals(0,0,"text2"); })
                );

    }

    @TestFactory
    List<DynamicTest> tests2() {

        return Arrays.asList(
                DynamicTest.dynamicTest("11",() -> { Assertions.assertEquals(0,0,"text"); }),
                DynamicTest.dynamicTest("22",() -> { Assertions.assertEquals(0,0,"text2"); })
        );

    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

}
