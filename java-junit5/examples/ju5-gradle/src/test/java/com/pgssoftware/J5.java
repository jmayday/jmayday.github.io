package com.pgssoftware;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

public class J5 {

    private List<DynamicTest> tests = new ArrayList<>();

    protected void λ(String displayName, Executable test) {
        tests.add(DynamicTest.dynamicTest(displayName, test));
    }

    @TestFactory
    List<DynamicTest> tests() {
        return tests;
    }
}
